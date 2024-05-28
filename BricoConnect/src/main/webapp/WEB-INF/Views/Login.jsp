<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Animated Login Form</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="Assets/css/LoginStyle.css">
</head>
<body>
    
    <div class="container" id="container">
        <div class="form-container sign-up">
            <form action="LoginServlet" method="post"> >
                <h1 style="text-align: center;">Accès Artisan</h1>
                <div class="social-icons">
                    <a href="#" class="icon">
                        <i class="fa-brands fa-google-plus-g"></i>
                    </a>
                    <a href="#" class="icon">
                        <i class="fa-brands fa-facebook-f"></i>
                    </a>
                    <a href="#" class="icon">
                        <i class="fa-brands fa-linkedin-in"></i>
                    </a>
                </div>
                <span>connexion par Email</span>
                <input type="email" name='email' 
                placeholder="Email">
                <input type="password"   name='password'
                placeholder="Password">
                <input type="hidden" id="userType" name="userType" value="artisan">
                <a href="">Créer un compte</a>
                <button>Se connecter</button>
            </form>
        </div>
        <div class="form-container sign-in">
            <form action="LoginServlet" method="post"> >
                <h1 style="justify-content: center;">Accès Employeur</h1>
                <div class="social-icons">
                    <a href="#" class="icon">
                        <i class="fa-brands fa-google-plus-g"></i>
                    </a>
                    <a href="#" class="icon">
                        <i class="fa-brands fa-facebook-f"></i>
                    </a>
                    <a href="#" class="icon">
                        <i class="fa-brands fa-linkedin-in"></i>
                    </a>
                </div>
                <span>connexion par Email</span>
                <input type="email"  name='email'
                placeholder="Email">
                <input type="password"  name='password'
                placeholder="Password">
                <input type="hidden" id="userType" name="userType" value="employeur">
                <a href="">Créer un compte</a>
                <button>Se connecter</button>
            </form>
        </div>
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-left">
                    <h1>Bienvenue <br> Artisan !</h1>
                    <p>Boostez votre visibilité et obtenez des opportunités de projet en vous connectant en tant qu'artisan.</p>
                    <button class="hidden" id="login">Je suis un employeur</button>
                </div>
                <div class="toggle-panel toggle-right">
                    <h1>Bienvenue Employeur !</h1>
                    <p>Trouvez le meilleur artisan pour votre projet de construction ou de rénovation en quelques clics !</p>
                    <button class="hidden" id="register">Je suis un Artisan</button>
                </div>
            </div>
        </div>
    </div>


    <script src="Assets/js/LoginScript.js"></script>
</body>
</html>