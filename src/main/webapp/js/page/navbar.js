let array_custom_link = document.querySelectorAll('.custom-link');

array_custom_link.forEach((elementDeChaqueClasse) => {
    elementDeChaqueClasse.addEventListener("mouseover", elementDeChaqueClasseMouseOver);
    function elementDeChaqueClasseMouseOver() {
        elementDeChaqueClasse.classList.add('border-top', 'border-bottom');
        elementDeChaqueClasse.style.color = "orange";
    }
});

array_custom_link.forEach((element) => {
    element.addEventListener("mouseout", () => {
        element.classList.remove('border-top', 'border-bottom');
        element.style.color = "black";
    });
});


console.log("hello")
//document.addEventListener("DOMContentLoaded", function() {
//    console.log("hello");
//
//    const navItems = document.querySelectorAll('.nav-item');
//
//    navItems.forEach(function(navbar) {
//        navbar.addEventListener("mouseover", navItem);
//        navbar.addEventListener("mouseout", navItemOut);
//    });
//
//    function navItem() {
//        this.style.textDecoration = "underline overline orange";
//    }
//
//    function navItemOut() {
//        this.style.textDecoration = "none";
//    }
//});