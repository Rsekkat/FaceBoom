//Imports
var express    = require('express');
var bodyParser = require('body-parser');
var apiRouter  = require('./apiRouter').router;

//Instantiate server
var server = express();

// Body parser configuration
server.use(bodyParser.urlencoded({ extended: true}));
server.use(bodyParser.json());

//Variables
var port = 8080;

//Configure route
server.get('/', function(req, res) {
    //En-tête de la requête reponse (renvoie un text en html)
    res.setHeader('Content-Type', 'text/html');
    res.status(200).send('<h1>test server : ok</h1>');
});

server.use('/api/', apiRouter);

//Launch server
server.listen(port, function() {
    console.log('server en écoute sur le port : ' + port);
});