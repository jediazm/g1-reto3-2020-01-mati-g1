package co.edu.uniandes.tianguix.notificator.controller;

import co.edu.uniandes.tianguix.commons.model.Notification;
import co.edu.uniandes.tianguix.commons.model.NotificationType;
import co.edu.uniandes.tianguix.commons.model.User;
import co.edu.uniandes.tianguix.notificator.rest.SlackClient;
import co.edu.uniandes.tianguix.notificator.service.NotificationServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SlackClientController {

    private NotificationServiceImpl slackService = new NotificationServiceImpl(new SlackClient());

    @PostMapping(value = "/slackNotification")
    public void sendNotification(){
        ArrayList<User> recipients = new ArrayList<>();
        recipients.add(new User("1","Daniel","daniel@mail.com"));
        recipients.add(new User("2","Esteban","esteban@mail.com"));
        recipients.add(new User("3","Diego","diego@mail.com"));
        slackService.notify(new Notification(NotificationType.ORDER_CREATION,"nuevaOrden1", recipients));
    }
}
