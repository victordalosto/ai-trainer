(() => {
    const formParameter = document.getElementById('form-parameters');
    const formClassification = document.getElementById('form-classification');


    function updateColor() {
        formParameter.style.borderColor = formParameter.options[formParameter.selectedIndex].getAttribute("color");;
        formClassification.style.borderColor = formClassification.options[formClassification.selectedIndex].getAttribute("color");;
    }

    
    formParameter.addEventListener('change', function() {
        updateColor();
    });


    formClassification.addEventListener('change', function() {
        updateColor();
    });


    updateColor();

})();