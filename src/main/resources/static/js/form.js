(() => {
    const formParameter = document.getElementById('form-tipo');
    const qualidade = document.getElementById('form-qualidade');

    updateColor();
    alteraCorQualidade();

    function updateColor() {
        const color = formParameter.options[formParameter.selectedIndex]
                          .getAttribute("color");
        formParameter.style.borderColor = color;
    }


    function alteraCorQualidade() {
        const value = qualidade.value.toLowerCase();
        if (value == 'boa') {
            qualidade.style.borderColor = 'green';
        } else if (value == 'ruim') {
            qualidade.style.borderColor = 'red';
        } else {
            qualidade.style.borderColor = 'orange';
        }
    }

    formParameter.addEventListener('change', function() {
        updateColor();
    });

    qualidade.addEventListener('change', function() {
        alteraCorQualidade();
    });
})();