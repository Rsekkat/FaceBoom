//Imports
var express = require('express');

//Instantiate server
var server = express();

//Variables
var port = 8080;

//Configure route
server.get('/', function(req, res) {
    //En-tête de la requête reponse (renvoie un text en html)
    res.setHeader('Content-Type', 'text/html');
    res.status(200).send('<h1>test server : ok</h1>');
});

//Launch server
server.listen(port, function() {
    console.log('server en écoute sur le port : ' + port);
});