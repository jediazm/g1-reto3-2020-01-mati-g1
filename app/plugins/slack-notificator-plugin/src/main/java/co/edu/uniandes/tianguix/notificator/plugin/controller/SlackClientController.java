package co.edu.uniandes.tianguix.notificator.plugin.controller;

import co.edu.uniandes.tianguix.notificator.plugin.service.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlackClientController {
    @Autowired
    private SlackClient slackClient;

    @PostMapping(value = "/slackNotification")
    public void sendNotification(){
        slackClient.sendMessage("Hola es un mensaje desde Tianguix");
    }
}
