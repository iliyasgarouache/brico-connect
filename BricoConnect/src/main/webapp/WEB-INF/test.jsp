<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Artisan</title>
</head>
<body>

<h1>Add Artisan</h1>

<form action="ArtisanServlett?action=update" method="post">


    <label for="nom">Nom:</label>
    <input type="text" id="nom" name="nom" required><br>

    <label for="prenom">Prenom:</label>
    <input type="text" id="prenom" name="prenom" required><br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" required><br>

    <label for="motDePasse">Mot de Passe:</label>
    <input type="password" id="motDePasse" name="motDePasse" required><br>

    <label for="cin">CIN:</label>
    <input type="text" id="cin" name="cin" required><br>

    <label for="numeroDeTelephone">Numero de Telephone:</label>
    <input type="text" id="numeroDeTelephone" name="numeroDeTelephone" required><br>

    <label for="adresse">Adresse:</label>
    <textarea id="adresse" name="adresse" required></textarea><br>

    <label for="noteGlobArtisan">Note Globale Artisan:</label>
    <input type="text" id="noteGlobArtisan" name="noteGlobArtisan" required><br>

    <label for="langues">Langues:</label>
    <input type="text" id="langues" name="langues" required><br>

    <label for="formation">Formation:</label>
    <textarea id="formation" name="formation" required></textarea><br>

    <label for="experienceProfessionnelle">Experience Professionnelle:</label>
    <textarea id="experienceProfessionnelle" name="experienceProfessionnelle" required></textarea><br>

    <label for="competences">Competences:</label>
    <textarea id="competences" name="competences" required></textarea><br>

   

    <input type="submit" value="Add Artisan">
</form>

</body>
</html>