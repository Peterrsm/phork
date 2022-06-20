# Serviço 'phork'

Este é um serviço Rest que inicia com uma lista de 5 pessoas e quem se conhece entre elas. 

O objetivo deste serviço é organizar quem conhece quem e, para isso, os seguintes endpoints são expostos<br>
-> GET '/fork"/pessoas' - Retorna todas as pessoas cadastradas<br>
-> POST '/fork/pessoas' - Cadastra uma nova pessoa e seus respectivos conhecidos<br>
-> GET '/fork"/pessoas/{id}' - Retorna o nome da pessoa referente à respectiva posição na lista e seus respectivos conhecidos<br>
-> GET "/fork/pessoas/conhecidas/{nome}" - Retorna as pessoas conhecidas pela pessoa referente ao parâmetro {nome}<br>
-> GET "fork/pessoas/desconhecidas/{nome}" - Tomando a pessoa referente ao parâmetro {nome}, retorna as pessoas que os conhecidos conhecem, mas ela desconhece<br><br>


Ao iniciar o serviço já instancia e populada a lista, para não iniciar vazia, com 6 registros e seus respectivos conhecidos:<br>
- Ana conhece Vinicius, Maria, Carlos e Joao<br>
- Maria conhece Ana e Vinicius
- Vinicius conhece Ana e Maria
- Carlos conhece Ana
- Joao conhece Ana e Luiza
- Luiza conhece Joao

<hr>

Considerando o tamanho do serviço foi considerado utilizar o pattern Builder, mas com o uso da biblioteca <b>lombok</b> não foi necessário.

Para acessar o Swagger: http://localhost:8080/swagger-ui.html