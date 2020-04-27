package co.edu.uniandes.tianguix.notificator.service;

import co.edu.uniandes.tianguix.commons.model.Notification;
import co.edu.uniandes.tianguix.commons.plugin.NotificationProviderPlugin;
import co.edu.uniandes.tianguix.notificator.rest.SlackClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationProviderPlugin {
    // -----------------------------------------------------------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------------------------------------------------------

    private final SlackClient slackClient;


    @Override
    public void notify(Notification notification) {

        var message = getNotificationMessage(notification);
        slackClient.sendMessage(message);

    }

    // -----------------------------------------------------------------------------------------------------------------
    // Inner logic
    // -----------------------------------------------------------------------------------------------------------------

    private String getNotificationMessage(Notification notification) {

        return getNotificationTemplate()
                .replace("orderType", notification.getType().toString())
                .replace("orderId", notification.getOrderId())
                .replace("recipients", notification.getRecipients().toString());
    }

    private String getNotificationTemplate() {

        var inputStream = getClass().getClassLoader().getResourceAsStream("notification.json");
        var reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
}

