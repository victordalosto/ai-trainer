(() => {
    const tipo = document.getElementById('form-tipo');
    const qualidade = document.getElementById('form-qualidade');

    alteraCorTipo();
    alteraCorQualidade();

    function alteraCorTipo() {
        const value = tipo.value.toLowerCase();
        if (value == 'regulamentacao') {
            tipo.style.borderColor = 'red';
        } 
        else if (value == 'advertencia') {
            tipo.style.borderColor = 'rgb(225, 169, 24)';
        } 
        else if(value == 'indicativa') {
            tipo.style.borderColor = 'green';
        }
        else if(value == 'servicos') {
            tipo.style.borderColor = 'blue';
        }
        else if(value == 'educativa') {
            tipo.style.borderColor = 'white';
        }
        else if(value == 'turistico') {
            tipo.style.borderColor = 'brown';
        } 
        else {
            tipo.style.borderColor = 'black';
        }

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

    tipo.addEventListener('change', function() {
        alteraCorTipo();
    });

    qualidade.addEventListener('change', function() {
        alteraCorQualidade();
    });
})();