function validate() {
	const
	firstName = document.querySelector('#first-name');
	const
	lastName = document.querySelector('#last-name');
	const
	email = document.querySelector('#email');
	const
	mobile = document.querySelector('#mobile');
	const
	messageDiv = document.querySelector('#message');
	if (firstName.value === '' || lastName.value === '' || email.value === ''
			|| mobile.value === '') {
		generateMessage(messageDiv,'All parameters are mandatory','error');
	} else {
		registerUser(firstName, lastName, email, mobile)
		
	}
}

function generateMessage(messageDiv,message,divName) {
	const
	newDiv = document.createElement('div');
	newDiv.className = divName+'-Div';
	newDiv.appendChild(document.createTextNode(message));
	console.log(newDiv);
	console.log(messageDiv);
	messageDiv.appendChild(newDiv);
}

function registerUser(firstName, lastName, email, mobile) {
	const
	inputFields = {
		'firstName' : firstName.value,
		'lastName' : lastName.value,
		'email' : email.value,
		'mobile' : mobile.value
	};
	const
	payload = JSON.stringify(inputFields);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		alert('1');
		if (this.status == 201) {
			alert('2');
			const
			messageDiv = document.querySelector('#message');
			generateMessage(messageDiv,'Success','success');
			alert('3');
		}
	};
	xhttp.open('POST',
			'http://localhost:2000/customer-registration/registration', true);
	xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xhttp.send(payload);
}