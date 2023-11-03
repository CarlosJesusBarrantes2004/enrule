//*Popup
const nuOption = document.getElementById("normal-user-option");
const cuOption = document.getElementById("company-user-option");
const nuQuestions = document.getElementById("normal-user-questions");
const cuQuestions = document.getElementById("company-user-questions");

function handleOptionChange(option, questions, otherQuestions) {
  if (option.checked) {
    questions.classList.remove("hidden");
    otherQuestions.classList.add("hidden");

    Array.from(questions.children).forEach((p) => {
      Array.from(p.children)[1].removeAttribute("disabled");
    });

    Array.from(otherQuestions.children).forEach((p) => {
      Array.from(p.children)[1].setAttribute("disabled", "disabled");
      p.children[1].value = "";
    });
  }
}

nuOption.addEventListener("change", () =>
  handleOptionChange(nuOption, nuQuestions, cuQuestions)
);

cuOption.addEventListener("change", () =>
  handleOptionChange(cuOption, cuQuestions, nuQuestions)
);

const resetModal = function (formId, modal) {
  modal._element.addEventListener("hidden.bs.modal", () => {
    document.getElementById(formId).reset();
    nuQuestions.classList.add("hidden");
    cuQuestions.classList.add("hidden");
  });
};

let popupSignUp = new bootstrap.Modal(document.getElementById("popup-sign-up"));
let popupLogin = new bootstrap.Modal(document.getElementById("popup-login"));

document.addEventListener("DOMContentLoaded", function () {
  resetModal("form-sign-up", popupSignUp);
  resetModal("form-login", popupLogin);
});

const changePopup = function (showPopup, hidePopup) {
  showPopup.show();
  hidePopup.hide();
};

document
  .getElementById("hyper-login")
  .addEventListener("click", () => changePopup(popupLogin, popupSignUp));

document
  .getElementById("hyper-sign-up")
  .addEventListener("click", () => changePopup(popupSignUp, popupLogin));

//**Home
const hearts = document.querySelectorAll(".purple-heart");

hearts.forEach((heart) => {
  heart.addEventListener("click", () => {
    if (heart.classList.contains("purple")) {
      heart.classList.remove("purple");
    } else {
      heart.classList.add("purple");
    }
  });
});
