# PROJETO PARA CALCULO DE TAXA DE MORTALIDADE POR GENERO POR ANO E PAÍS
-- Foi criado um mock do serviço INE para simular a leitura dos dados do serviço externo de INE
-- Este projeto será divido em dois módulos(back e front)
    -- A parte front será em angular e vai consumir este serviço a partir da tela do usuário

## Para rodar o projeto localmente, precisa:
    -- Maven a partir de 3.8
    -- JDK21
    -- collection está anexado no projeto, pasta resource
    -- Obs.: As portas podem variar conforme o usuario local
    -- exemplo de arquivo .csv está anexado no projeto, pasta resource

    -- Obs.: Não foi utilizado lombok devido problema de dependências na maquina

# Breve descritivo do projeto
    Uma seguradora necessita de um serviço e uma aplicação para manutenção de tabelas de mortalidade. Uma tabela de mortalidade (simplificada) permite
    saber para um dado ano, num dado país, qual o numero de mortes por 1000 habitantes de acordo com o sexo. Ex:


    ----------------------------------------
    Tabela de mortalidade 2016
    País	Tx Feminino	Tx Masculino
    ----------------------------------------
    …	    	…	        …
    PT	    	3,21	    	4,5
    SP	    	3,15	    	4,56
    …	    	…	        …
                

    ----------------------------------------
    Tabela de mortalidade 2017
    País	Tx Feminino	Tx Masculino
    ----------------------------------------
    …	    	…	        …
    PT	    	3,14	    	3,99
    SP	    	3,15	    	4,34
    …	    	…	        …


    O código do país é um acrónimo de acordo com a norma ISO 3166
    As taxas de mortalidade tem duas casas decimais estando limitadas entre 0,00 e 1000,00
    
    Pretende-se um serviço REST que permita:
    •	Consulta de uma tabela de mortalidade de um dado ano
    •	Atualização/criação de um registo de taxa de mortalidade para um dado ano e país
    •	ao registar uma entrada da tabela de mortalidade, esta deve ser complementada automaticamente com duas colunas adicionais correspondentes à população masculina e
    população feminina de cada país, ex.,  em 2017 havia em Portugal 4.523.172 indivíduos do sexo masculino e 5.145.768 indivíduos do sexo feminino.
    esta informação é obtida de um serviço externo (ex., INE) que pode variar em cada implantação da aplicação. para efeitos de teste deve ser possível utilizar um serviço mock.
    •	upload de um ficheiro CSV com os dados de mortalidade de um dado ano, que deve reescrever totalmente a tabela de mortalidade desse ano
    
    Deve ainda ser disponibilizada uma coleção POSTMAN (ou semelhante) para a utilização da API que possa ser executada automaticamente e inclua testes.

