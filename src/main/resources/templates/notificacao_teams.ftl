{
    "@type": "MessageCard",
    "@context": "http://schema.org/extensions",
    "themeColor": "0076D7",
    "summary": "Teste notificação teams",
    "sections": [{
        "activityTitle": "Nova Notificação",
        "activitySubtitle": "Projeto teams-server",
        "facts": [{
            "name": "Mensagem",
            "value": "${mensagem}"
        }, {
            "name": "Status",
            "value": "${status}"
        }],
        "markdown": true
    }]
}