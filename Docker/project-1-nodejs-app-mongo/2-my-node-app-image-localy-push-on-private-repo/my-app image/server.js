const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
const bodyParser = require('body-parser');
const path = require('path');
const app = express();

// Enable CORS for frontend to communicate with the backend
app.use(cors());

// Middleware to parse JSON data
app.use(bodyParser.json());

// Serve static files (e.g., frontend)
app.use(express.static('public'));

// Serve the edit-profile page when accessing the root
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'edit-profile.html'));
});

// Connect to MongoDB
mongoose.connect('mongodb://admin:password@localhost:27017/userProfileDB?authSource=admin', {
  useNewUrlParser: true,
  useUnifiedTopology: true,
}).then(() => {
  console.log('MongoDB connected');
}).catch(err => {
  console.log('MongoDB connection error:', err);
});

// Define Mongoose schema for User profile
const userSchema = new mongoose.Schema({
  name: { type: String, required: true },
  email: { type: String, required: true, unique: true },
  bio: { type: String, required: true }
});

// Create the User model
const User = mongoose.model('User', userSchema);

// Route to create a new user profile
app.post('/api/profile', async (req, res) => {
  console.log('Received data:', req.body); // Debugging log

  try {
    const newUser = new User(req.body);
    const savedUser = await newUser.save();
    res.json(savedUser); // Respond with saved user data
  } catch (err) {
    console.error('Error creating user:', err);
    res.status(500).json({ error: 'Create failed' }); // Send error if database fails
  }
});

// Route to get a specific user profile by ID
app.get('/api/profile/:id', async (req, res) => {
  try {
    const user = await User.findById(req.params.id);
    if (!user) {
      return res.status(404).json({ error: 'User not found' });
    }
    res.json(user); // Return the user data
  } catch (err) {
    console.error('Error fetching user:', err);
    res.status(500).json({ error: 'Failed to retrieve user' });
  }
});

// Route to get all user profiles
app.get('/api/profile', async (req, res) => {
  try {
    const users = await User.find();  // Fetch all users
    res.json(users); // Respond with the list of users
  } catch (err) {
    console.error('Error fetching users:', err);
    res.status(500).json({ error: 'Failed to retrieve users' });
  }
});

// Start the server on port 3000
app.listen(3000, () => {
  console.log('Server running on http://localhost:3000');
});
