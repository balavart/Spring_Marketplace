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
  document.getElementsByClassName("offer_table")[0].addEventListener("change",
      offerOnChange);
  document.getElementsByClassName("offer_table")[0].addEventListener("submit",
      onsubmitHandler);
  document.getElementsByClassName("offer_table")[0].addEventListener("click",
      onsubmitHandler);
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

function validateBid(input) {
  const pattern = "^\\d+(,\\d{3})*(\\.\\d{1,2})?$";
  validate(input, pattern);
}

/**
 * event handlers for changing text in the offer window.
 */
function offerOnChange(e) {
  const input = e.target;
  if (input.name === "offer") {
    validateBid(input);
  }
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

function warning(enteredOffer, form) {

// Get the modal
  const modal = document.getElementById("warningModal");
  modal.style.display = "block";

  const offer = document.getElementById("enteredOffer");
  offer.innerHTML = enteredOffer;

  // Get the button that opens the modal
  const okBtn = document.getElementById("confirmButton");
  const cancelBtn = document.getElementById("negativeButton");

  // Get the <span> element that closes the modal
  const span = modal.getElementsByClassName("close")[0];

  okBtn.onclick = function () {
    modal.style.display = "none";
    form.submit();
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

function submitBid(event, form) {
  event.preventDefault();

  let invalid = false;
  const inputs = form.getElementsByClassName('offer_input');

  for (let i = 0; i < inputs.length; ++i) {
    const element = inputs[i];
    validateBid(element);

    if (element.classList.contains("invalid")) {
      invalid = true;
    }
  }

  if (invalid) {
    invalidFilling();
  } else {
    warning(form.offer.value, form);
  }
}

/**
 * event when a form is submitted to the server.
 */
function onsubmitHandler(event) {
  const form = event.target;

  if (form.classList.contains("offer_form")) {
    submitBid(event, form);
  }

}

function onSendClick(e) {
  const btn = e.target;

  if (btn.classList.contains("offer_button")) {
    submitBid(e, btn.parentElement)
  }

}