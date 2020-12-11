// Imports
var bcrypt = require('bcrypt');
var jwt    = require('jsonwebtoken');
var models = require('../models');

// Routes
module.exports = {
    register: function(req, res) {

        // Params
        var email    = req.body.email;
        var username = req.body.username;
        var password = req.body.password;
        var bio      = req.body.bio;

        if (email == null || username == null || password == null) {
            return res.status(400).json({'error': 'missing parameters'});
        }

        models.User.findOne({
            attributes: ['email'],
            where: { email: email }
        })
        .then(function(userFound) {
            if (!userFound) {
                bcrypt.hash(password, 5, function( err, bcryptPassword) {
                    var newUser = models.User.create({
                        email: email,
                        username: username,
                        password: bcryptPassword,
                        bio: bio,
                        isAdmin: 0
                    })
                    .then(function(newUser) {
                        return res.status(201).json({
                            'userId': newUser.id
                        })
                    })
                    .catch(function(err) {
                        return res.status(500).json({ 'error': 'cannot add user'});
                    })
                });
            } else {
                return res.status(409).json({ 'error': 'user already exist'});
            }
        })
        .catch(function(err) {
            return res.status(500).json({ 'error': 'unable to verify user'});
        });

    },
    login: function(req, res) {

    }
}