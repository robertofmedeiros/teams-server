# Projeto Notificação Teams
Projeto de exemplo de utilização webhook do ms teams,
para ser usado para notificar alertas ou erros.
## Pre-requisitos
* java 11
* spring boot 2.4.5
* freemaker
* lombok
## Freemaker
Foi utilizando o freemaker para montar a template json de envio para o teams.
Para notificações diferentes é somente criar novas templates com novos parametros.
## Webhook Teams
Deve ser criado um webhook na aplicação do teams, e a url gerada deve ser adicionada no
arquivo application.yml