
let array_card_img_top = document.querySelectorAll('.card-index');

array_card_img_top.forEach((element) => {
    element.addEventListener("mouseover", elementMouseOver);
    element.addEventListener("mouseout", elementMouseOut);
});

function elementMouseOver() {
    this.style.outline = "1px solid #1c87c9";
    this.style.outlineOffset = "0.5px";
    this.style.boxShadow = "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 #1c87c9";

}

function elementMouseOut() {
    this.style.outline = "none";
    this.style.outlineOffset = "none";
    this.style.boxShadow = "none";
}


/*let custom_card = document.querySelectorAll('.custom-card');
custom_card.forEach((element) => {
    element.addEventListener("mouseover", displayMouseOver);
    element.addEventListener("mouseout", displayMouseOut);

});
    function displayMouseOver() {
        this.style.display = "none";
        console.log("je suis dans le hover");
    }

    function displayMouseOut() {
        this.style.display = "block";
    }*/


