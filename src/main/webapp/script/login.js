const loginBtn = document.getElementById('loginBtn');
const registerBtn = document.getElementById('registerBtn');

loginBtn.addEventListener('click', function () {
    // Toggle active class
    loginBtn.classList.add('active');
    registerBtn.classList.remove('active');

    // Show the login container and hide the register container
    document.getElementById('loginContainer').style.display = 'block';
    document.getElementById('registerContainer').style.display = 'none';

    // Change page title to "Login"
    document.title = 'Blue Queen Cafe Login';
});

registerBtn.addEventListener('click', function () {
    // Toggle active class
    registerBtn.classList.add('active');
    loginBtn.classList.remove('active');

    // Show the register container and hide the login container
    document.getElementById('registerContainer').style.display = 'block';
    document.getElementById('loginContainer').style.display = 'none';

    // Change page title to "Register"
    document.title = 'Blue Queen Cafe Register';
});
