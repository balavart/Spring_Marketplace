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
  document.login_form.username.onchange = loginOnChange;
  document.login_form.password.onchange = passwordOnChange;
  document.login_form.onsubmit = onsubmitHandler;
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

function warning(enteredUserName) {

// Get the modal
  const modal = document.getElementById("warningModal");
  modal.style.display = "block";

  const userName = document.getElementById("userName");
  userName.innerHTML = enteredUserName;

  // Get the button that opens the modal
  const okBtn = document.getElementById("confirmButton");
  const cancelBtn = document.getElementById("negativeButton");

  // Get the <span> element that closes the modal
  const span = modal.getElementsByClassName("close")[0];

  okBtn.onclick = function () {
    modal.style.display = "none";
    document.login_form.submit();
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

  for (let i = 0; i < document.login_form.elements.length; ++i) {
    const element = document.login_form.elements[i];
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
    warning(document.login_form.username.value);
  }
}
