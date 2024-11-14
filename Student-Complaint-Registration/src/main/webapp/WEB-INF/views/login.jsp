<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
    <script type="text/javascript" src="${context}/resources/js/jquery-3.4.1.min.js"></script> 
    <script type="text/javascript" src="${context}/resources/js/jquery.validate_1.19.1.min.js"></script>  

<style>
body {
    background-color: #f0f8ff; 
    margin: 0;
    font-family: Arial, sans-serif;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
}

header {
    background-color: #4CAF50; /* Green background */
    color: white;
    width: 100%;
    text-align: center;
    padding: 20px 0;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    position: relative;
}

header h1 {
    margin: 0;
}

.header-button {
    position: absolute;
    top: 50%;
    right: 20px;
    transform: translateY(-50%);
    background-color: #ffffff; /* White background for the button */
    color: #4CAF50; /* Green text */
    padding: 10px 20px;
    border: 2px solid #4CAF50;
    border-radius: 4px;
    text-decoration: none;
    font-weight: bold;
    transition: background-color 0.3s, color 0.3s;
}

.header-button:hover {
    background-color: #4CAF50; /* Green background on hover */
    color: white; /* White text on hover */
}

main {
    display: flex;
    justify-content: center;
    align-items: center;
    flex: 1;
    width: 100%;
}

.login-container, .reset-password-container {
    background-color: #ffffff; /* White background for the form */
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 300px;
    text-align: center;
}

h2 {
    margin-bottom: 20px;
    color: #333333;
}

label {
    display: block;
    margin: 10px 0 5px;
    color: #555555;
}

input {
    width: 100%;
    padding: 8px;
    margin-bottom: 5px;
    border: 1px solid #cccccc;
    border-radius: 4px;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50; /* Green background */
    color: white;
    padding: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    width: 100%;
}

button:hover {
    background-color: #45a049; /* Darker green */
}

a {
    display: block;
    margin-top: 10px;
    color: #4CAF50;
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}

.general-error-message {
    color: red;
    margin-top: 20px;
    display: none;
}
</style>
</head>
<body> 
   <header>
        <h1>Welcome to Our Website</h1>
        <a href="https://chatgpt.com/" class="header-button">CMR BOAT</a>
    </header>
    <main>
        <div class="login-container">
        <span style="color:red; text-align: center;padding: 10px;font-size: 0.9em; animation: fadeOut 5s forwards;">${message}</span>
            <h2>Login</h2>
            <form id="login-form" action="/login" method="POST" modelAttribute="loginAttribute" novalidate="novalidate" onsubmit="return validateLoginForm()">
                <label for="email">Email ID:</label>
                <input type="email" id="email" name="email" required>
                <span id="email-error" class="error-message"></span>
                
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
                <span id="password-error" class="error-message"></span>
                
                <button type="submit">Login</button>
            </form>
            <a href="#" id="forgot-password-link">Forgot Password?</a>
        </div>
    </main>
    <script>
        function validateLoginForm() {
            let email = document.getElementById('email').value;
            let password = document.getElementById('password').value;
            let valid = true;

            // Email validation
            let emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
            if (!emailPattern.test(email)) {
                valid = false;
                document.getElementById('email-error').textContent = 'Please enter a valid email address.';
                document.getElementById('email-error').style.display = 'block';
            } else {
                document.getElementById('email-error').style.display = 'none';
            }

            // Password validation
            if (password.length < 8) {
                valid = false;
                document.getElementById('password-error').textContent = 'Password must be at least 8 characters long.';
                document.getElementById('password-error').style.display = 'block';
            } else {
                document.getElementById('password-error').style.display = 'none';
            }

            // General error message
            if (!valid) {
                document.getElementById('general-error-message').textContent = 'Please correct the errors above and try again.';
                document.getElementById('general-error-message').style.display = 'block';
            } else {
                document.getElementById('general-error-message').style.display = 'none';
            }

            return valid;
        }
    </script>
</body>
</html>
