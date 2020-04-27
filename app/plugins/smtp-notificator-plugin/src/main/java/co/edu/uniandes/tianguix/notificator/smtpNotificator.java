package co.edu.uniandes.tianguix.notificator;

import co.edu.uniandes.tianguix.commons.model.Notification;
import co.edu.uniandes.tianguix.commons.model.NotificationType;
import co.edu.uniandes.tianguix.commons.model.User;
import co.edu.uniandes.tianguix.notificator.service.SMTPPlugin;
import co.edu.uniandes.tianguix.notificator.smtp.SMTPClient;

import java.util.ArrayList;


public class smtpNotificator {
    public static void main(String[] args) {
        SMTPPlugin.PluginImpl slackService = new SMTPPlugin.PluginImpl();
        ArrayList<User> recipients = new ArrayList<>();
        recipients.add(new User("1","Daniel","daniel@mail.com"));
        recipients.add(new User("2","Esteban","esteban@mail.com"));
        recipients.add(new User("3","Diego","diego@mail.com"));
        slackService.notify(new Notification(NotificationType.ORDER_CREATION,"nuevaOrden1", recipients));
    }
}
