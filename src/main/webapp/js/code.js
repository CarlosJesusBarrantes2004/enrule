//**Index
//*Popup
const signUpBtn = document.querySelector(
  ".header-login .content-btn:nth-child(1)"
);
const loginBtn = document.querySelector(
  ".header-login .content-btn:nth-child(2)"
);
const closeBtn = document.getElementById("close-btn");
const popup = document.getElementById("popup");

const formSignUp = document.getElementById("form-sign-up");
const formLogin = document.getElementById("form-login");
const hyperSignUp = document.getElementById("hyper-sign-up");
const hyperLogin = document.getElementById("hyper-login");

function showForm(formToShow) {
  formSignUp.style.display = "none";
  formLogin.style.display = "none";
  formToShow.style.display = "flex";
  popup.style.display = "flex";
}

function resetForms() {
  formSignUp.reset();
  formLogin.reset();
}

signUpBtn.addEventListener("click", () => {
  showForm(formSignUp);
});

loginBtn.addEventListener("click", () => {
  showForm(formLogin);
});

hyperSignUp.addEventListener("click", () => {
  resetForms();
  showForm(formSignUp);
});

hyperLogin.addEventListener("click", () => {
  resetForms();
  showForm(formLogin);
});

closeBtn.addEventListener("click", () => {
  resetForms();
  normalUserQuestions.classList.add("hidden");
  companyUserQuestions.classList.add("hidden");
  qstn.style.display = "flex";
  qstn.style.flexDirection = "column";
  popupContent.style.width = "30%";
  popup.style.display = "none";
});

//*Menu-options
const qstn = document.getElementById("questions");
const popupContent = document.getElementById("popup-content");
const normalUserOption = document.getElementById("normal-user-option");
const companyUserOption = document.getElementById("company-user-option");
const normalUserQuestions = document.getElementById("normal-user-questions");
const companyUserQuestions = document.getElementById("company-user-questions");

function handleOptionChange(option, questions, otherQuestions) {
  if (option.checked) {
    qstn.style.display = "grid";
    qstn.style.gridTemplateColumns = "repeat(2, 1fr)";
    qstn.style.gap = "10px";
    popupContent.style.width = "60%";

    questions.classList.remove("hidden");
    otherQuestions.classList.add("hidden");

    Array.from(questions.children).forEach((p) => {
      Array.from(p.children)[1].removeAttribute("disabled");
    });

    Array.from(otherQuestions.children).forEach((p) => {
      Array.from(p.children)[1].setAttribute("disabled", "disabled");
    });
  }
}

normalUserOption.addEventListener("change", () => {
  handleOptionChange(
    normalUserOption,
    normalUserQuestions,
    companyUserQuestions
  );
});

companyUserOption.addEventListener("change", () => {
  handleOptionChange(
    companyUserOption,
    companyUserQuestions,
    normalUserQuestions
  );
});

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
