package com.example.demoamqt;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MessageController {
    private final MessageProvider messageProducer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message){
        messageProducer.sendMessage(message);
        return "Message sent: " + message;
    }
}
