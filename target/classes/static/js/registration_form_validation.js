/**
 * registration of a document upload event.
 */
if (window.addEventListener) {
  window.addEventListener("load", init, false);
} else if (window.attachEvent) {
  window.attachEvent("onload", init);
}

/**
 * register event handlers for form elements.
 */
function init() {
  document.register_form.login.onchange = loginOnChange;
  document.register_form.password.onchange = passwordOnChange;
  document.register_form.password_replay.onchange = validatePassword;
  document.register_form.fullName.onchange = fullNameOnChange;
  document.register_form.city.onchange = cityOnChange;
  document.register_form.email.onchange = emailOnChange;
  document.register_form.phone.onchange = phoneOnChange;

  document.register_form.onsubmit = onsubmitHandler;
  const sendBtn = document.getElementById("dataSendButton");
  sendBtn.onclick = onsubmitHandler;
}

/**
 * method of checking the value in an element by regular expression.
 */
function validate(element, pattern) {
  const result = element.value.search(pattern);

  if (result === -1) {
    element.classList.add("invalid");
    element.classList.remove("valid");
  } else {
    element.classList.add("valid");
    element.classList.remove("invalid");
  }
}

/**
 * event handlers for changing text in the login window.
 */
function loginOnChange() {
  const pattern = "^[a-zA-Z][a-zA-Z0-9-_\\.]{3,20}$";
  validate(this, pattern);
}

/**
 * text change event handlers in the password window.
 */
function passwordOnChange() {
  const pattern = "^[a-zA-Z0-9_-]{6,20}$";
  validate(this, pattern);
}

/**
 * password matching method.
 */
function validatePassword() {
  const passwordReplay = document.register_form.password_replay.value;
  const password = document.register_form.password.value;

  if (password !== passwordReplay) {
    document.register_form.password_replay.setCustomValidity(
        "Passwords Don't Match");
  } else {
    document.register_form.password_replay.value.setCustomValidity('');
  }
}

/**
 * text change event handlers in the full name window.
 */
function fullNameOnChange() {
  const pattern = "^[A-Z][a-zA-Z\\-]{1,20}\\s[A-Z][a-zA-Z\\-]{1,20}(\\s[A-Z][a-zA-Z\\-]{1,20})?$";
  validate(this, pattern);
}

/**
 * event handlers for changing text in a city window.
 */
function cityOnChange() {
  const pattern = "^[a-zA-Z]+(?:[- `][a-zA-Z]+)*$";
  validate(this, pattern);
}

/**
 * text change event handlers in the email window.
 */
function emailOnChange() {
  const pattern = "^[_a-zA-Z0-9-\\+-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{2,20})$";
  validate(this, pattern);
}

/**
 * text change event handlers in the phone number window.
 */
function phoneOnChange() {
  const pattern = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
  validate(this, pattern);
}

function invalidFilling() {

// Get the modal
  const modal = document.getElementById("wrongFillingModal");
  modal.style.display = "block";

  // Get the button that opens the modal
  const exitBtn = document.getElementById("exitButton");

  // Get the <span> element that closes the modal
  const span = modal.getElementsByClassName("close")[0];

  exitBtn.onclick = function () {
    modal.style.display = "none";
  };

  // When the user clicks on <span> (x), close the modal
  span.onclick = function () {
    modal.style.display = "none";
  };

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function (event) {
    if (event.target === modal) {
      modal.style.display = "none";
    }
  }
}

function warning() {

// Get the modal
  const modal = document.getElementById("warningModal");
  modal.style.display = "block";


  // Get the button that opens the modal
  const okBtn = document.getElementById("confirmButton");
  const cancelBtn = document.getElementById("negativeButton");

  // Get the <span> element that closes the modal
  const span = modal.getElementsByClassName("close")[0];

  okBtn.onclick = function () {
    modal.style.display = "none";
    document.forms.register_form.submit();
  };

  cancelBtn.onclick = function () {
    modal.style.display = "none";
  };

  // When the user clicks on <span> (x), close the modal
  span.onclick = function () {
    modal.style.display = "none";
  };

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function (event) {
    if (event.target === modal) {
      modal.style.display = "none";
    }
  }
}

/**
 * event when a form is submitted to the server.
 */
function onsubmitHandler(event) {
  event.preventDefault();

  let invalid = false;

  for (let i = 0; i < document.register_form.elements.length; ++i) {
    const element = document.register_form.elements[i];
    if (element.type === "text" && element.onchange) {
      element.onchange();
      if (element.classList.contains("invalid")) {
        invalid = true;
      }
    }
  }

  if (invalid) {
    invalidFilling();
  } else {
    warning();
  }
}

