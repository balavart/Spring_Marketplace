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
  // document.deleteForm.userProductIdForDelete.onchange = offerOnChange;
  document.deleteForm.onsubmit = onsubmitHandler;
  const deleteBtn = document.getElementsByName("userProductIdForDelete");

  Array.from(deleteBtn).forEach(
      function(element, index, array) {
        element.getAttribute("value");
        console.log(element.parentElement);
      }
  );


  deleteBtn.onclick = onsubmitHandler;
}

function warning(/*enteredProduct*/) {

// Get the modal
  const modal = document.getElementById("warningModal");
  modal.style.display = "block";

  // const offer = document.getElementById("enteredProduct");
  // offer.innerHTML = enteredProduct;

  // Get the button that opens the modal
  const okBtn = document.getElementById("confirmButton");
  const cancelBtn = document.getElementById("negativeButton");

  // Get the <span> element that closes the modal
  const span = modal.getElementsByClassName("close")[0];

  okBtn.onclick = function () {
    modal.style.display = "none";
    document.forms.deleteForm.submit();
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

  warning();
}