// Forms color handler
(() => {

    const primaryLayer = document.getElementById('form-primaryLayer');
    const secondaryLayer = document.getElementById('form-secondaryLayer');


    function updateColor() {
        primaryLayer.style.borderColor = primaryLayer.options[primaryLayer.selectedIndex].getAttribute("color");;
        secondaryLayer.style.borderColor = secondaryLayer.options[secondaryLayer.selectedIndex].getAttribute("color");;
    }

    
    primaryLayer.addEventListener('change', function() {
        updateColor();
    });


    secondaryLayer.addEventListener('change', function() {
        updateColor();
    });


    updateColor();

})();


function goToPage(event) {
    if (event.key == 'Enter')  {
        const pageNumber = document.getElementById('page-number').value;
        window.location.href = `/?page=${pageNumber}`;
    }
}
