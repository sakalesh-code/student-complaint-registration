<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Complaint</title>
   <style>
   body {
    font-family: Arial, sans-serif;
    background: linear-gradient(to right, #e66465, #9198e5);
    color: #333;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    min-height: 100vh;
}

header {
    background: rgba(255, 255, 255, 0.8);
    padding: 20px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    position: relative;
}

.header-wrapper {
    display: flex;
    flex-direction: column;
    align-items: center;
    flex: 1;
}

header h1 {
    margin: 0;
}

.header-button {
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    background-color: #f44336;
    color: white;
    text-decoration: none;
    transition: background-color 0.3s;
}

.header-button:hover {
    background-color: #e53935;
}

main {
    flex: 1;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 20px;
}

section {
    background: rgba(255, 255, 255, 0.8);
    border-radius: 8px;
    padding: 20px;
    width: 80%;
    max-width: 600px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

section h2 {
    margin-top: 0;
}

form {
    display: flex;
    flex-direction: column;
}

label {
    margin: 10px 0 5px;
}

input, textarea {
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    margin-bottom: 10px;
}

button {
    padding: 10px;
    border: none;
    border-radius: 4px;
    background-color: #4CAF50;
    color: white;
    cursor: pointer;
    transition: background-color 0.3s;
}

button:hover {
    background-color: #45a049;
}

.error-message {
    color: red;
    display: none;
}

footer {
    background: rgba(255, 255, 255, 0.8);
    text-align: center;
    padding: 10px;
    font-size: 0.9em;
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
   
   </style>
</head>
<body>
    <header>
        <div class="header-wrapper">
            <h1>Complaint Registration System</h1>
        </div>
        <a href="http://localhost:8080" class="header-button">Exit Page</a>
    </header>

    <main>
        <section id="complaint-form-section">
            <h2>Register Your Complaint</h2>
            <form id="complaint-form"  action="/studentComplaint" method="POST"  modelAttribute="studentAttribute" novalidate="novalidate" onsubmit="return validateComplaintForm()">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
                <span id="name-error" class="error-message"></span>

                <label for="college-id">College ID:</label>
                <input type="text" id="college-id" name="collegeId" required>
                <span id="college-id-error" class="error-message"></span>

                <label for="email"> College Email ID:</label>
                <input type="email" id="email" name="email" required>
                <span id="email-error" class="error-message"></span>

                <label for="branch">Branch:</label>
                <input type="text" id="branch" name="branch" required>
                <span id="branch-error" class="error-message"></span>
                 <label for="contactNumber">Contact Number:</label>
                <input type="text" id="contactNumber" name="contactNumber" required>
                <span id="contactNumber-error" class="contactNumber-message"></span>

                <label for="complaint">Complaint:</label>
                <textarea id="complaint" name="complaint" required></textarea>
                <span id="complaint-error" class="error-message"></span>

                <button type="submit">Submit Complaint</button>
              <span style="color:green; text-align: center;padding: 10px;font-size: 0.9em;">${message}</span>
            </form>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 Complaint Management System</p>
    </footer>

    <script>
    function validateComplaintForm() {
        const name = document.getElementById('name').value.trim();
        const collegeId = document.getElementById('college-id').value.trim();
        const email = document.getElementById('email').value.trim();
        const branch = document.getElementById('branch').value.trim();
        const complaint = document.getElementById('complaint').value.trim();
        const contactNumber = document.getElementById('contactNumber').value.trim();
        let valid = true;

        // Clear previous error messages
        document.getElementById('name-error').style.display = 'none';
        document.getElementById('college-id-error').style.display = 'none';
        document.getElementById('email-error').style.display = 'none';
        document.getElementById('branch-error').style.display = 'none';
        document.getElementById('complaint-error').style.display = 'none';
        document.getElementById('contactNumber-error').style.display = 'none';

        // Name validation
        if (name === '') {
            valid = false;
            document.getElementById('name-error').textContent = 'Name is required.';
            document.getElementById('name-error').style.display = 'block';
        }

        // College ID validation
        if (collegeId === '') {
            valid = false;
            document.getElementById('college-id-error').textContent = 'College ID is required.';
            document.getElementById('college-id-error').style.display = 'block';
        }

        // Email validation
        const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailPattern.test(email)) {
            valid = false;
            document.getElementById('email-error').textContent = 'Please enter a valid email address.';
            document.getElementById('email-error').style.display = 'block';
        }

        // Branch validation
        if (branch === '') {
            valid = false;
            document.getElementById('branch-error').textContent = 'Branch is required.';
            document.getElementById('branch-error').style.display = 'block';
        }

        // Complaint validation
        if (complaint === '') {
            valid = false;
            document.getElementById('complaint-error').textContent = 'Complaint is required.';
            document.getElementById('complaint-error').style.display = 'block';
        }
        if (contactNumber === '') {
            valid = false;
            document.getElementById('contactNumber-error').textContent = 'Contact Number is required.';
            document.getElementById('contactNumber-error').style.display = 'block';
        }
        return valid;
    }
    </script>
</body>
</html>
