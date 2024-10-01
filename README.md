# Potfolio-project
Webstack - Portfolio Project
<p align="center"><a href="https://laravel.com" target="_blank"><img src="https://raw.githubusercontent.com/laravel/art/master/logo-lockup/5%20SVG/2%20CMYK/1%20Full%20Color/laravel-logolockup-cmyk-red.svg" width="400" alt="Laravel Logo"></a></p>

# About Laravel 

Laravel is a web application framework with expressive, elegant syntax. We believe development must be an enjoyable and creative experience to be truly fulfilling. 

## Learning Laravel

Laravel has the most extensive and thorough [documentation](https://laravel.com/docs) and video tutorial library of all modern web application frameworks, making it a breeze to get started with the framework.

You may also try the [Laravel Bootcamp](https://bootcamp.laravel.com), where you will be guided through building a modern Laravel application from scratch.


tobyselway/laravel_setup.md
Last active 5 months ago • Report abuse
Clone this repository at &lt;script src=&quot;https://gist.github.com/tobyselway/5ea6c3f09201ea7743e321279c8d9645.js&quot;&gt;&lt;/script&gt;
<script src="https://gist.github.com/tobyselway/5ea6c3f09201ea7743e321279c8d9645.js"></script>

##Initial Setup for Laravel Projects

#1. Clone the repository
Find a location on your computer where you want to store the project. A directory made for projects is generally a good choice.

Launch a bash console there and clone the project.

git clone https://github.com/organization/project.git

#2. cd into the project

You will need to be inside the project directory that was just created, so cd into it.

cd project_name

#3. Install composer dependencies

Whenever you clone a new Laravel project you must now install all of the project dependencies. This is what actually installs Laravel itself, among other necessary packages to get started.

composer install

#4. Install NPM dependencies

Similarly to composer, npm manages javascript, css, and node packages, so make sure to install those dependencies also.

npm install

#5. Copy the .env file

.env files are not generally committed to source control for security reasons. But there is a .env.example which is a template of the .env file that the project requires.

So you should make a copy of the .env.example file and name it .env so that you can setup your local deployment configuration in the next few steps.

cp .env.example .env

#6. Generate an app encryption key

Laravel requires you to have an app encryption key which is generally randomly generated and stored in your .env file. The app will use this encryption key to encode various elements of your application from cookies to password hashes and more.

Laravel’s command line tools thankfully make it easy to generate this. Run this command in the terminal to generate that key.

php artisan key:generate

#7. Create an empty database for the application

Create an empty database for your project using the database tools you prefer (phpmyadmin, datagrip, or any other mysql client).

#8. In the .env file, add database information to allow Laravel to connect to the database

You will want to allow Laravel to connect to the database that you just created in the previous step. To do this, you must add the connection credentials in the .env file and Laravel will handle the connection from there.

In the .env file fill in the DB_HOST, DB_PORT, DB_DATABASE, DB_USERNAME, and DB_PASSWORD options to match the credentials of the database you just created. This will allow you to run migrations in the next step.


#9. Migrate the database

Once your credentials are in the .env file, now you can migrate your database. This will create all the necessary tables in your database.

php artisan migrate

During Development
Compiling assets
To compile all sass and js assets using webpack, run the following command.

npm run dev

You can also run the following command that will continue running in your terminal and watch all relevant files for changes. Webpack will then automatically recompile your assets when it detects a change.

npm run watch

Local development server
To run a local development server you may run the following command. This will start a development server at http://localhost:8000.

php artisan serve
