// Forms color handler
(() => {

    const layer1 = document.getElementById('form-layer1');
    const layer2 = document.getElementById('form-layer2');


    function updateColor() {
        layer1.style.borderColor = layer1.options[layer1.selectedIndex].getAttribute('color');
        layer2.style.borderColor = layer2.options[layer2.selectedIndex].getAttribute('color');
    }

    
    layer1.addEventListener('change', function() {
        updateColor();
    });


    layer2.addEventListener('change', function() {
        updateColor();
    });


    updateColor();

})();


function goToPage(event) {
    if (event.key == 'Enter')  {
        const pageNumber = document.getElementById('page-number').value;
        const layerParam = document.getElementById('form-page').getAttribute('category');
        const location = '/?page=' + pageNumber + (layerParam ? `${layerParam}` : '');
        window.location.href = location;
    }
}
