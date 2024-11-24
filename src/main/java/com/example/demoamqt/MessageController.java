package com.example.demoamqt;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MessageController {
    private final MessageProvider messageProducer;

    @PostMapping("/v1/send")
    public String sendMessageV1(@RequestParam String message){
        messageProducer.sendMessage(message);
        return "Message sent: " + message;
    }

    /**
 curl -X POST http://localhost:8080/v2/send \
 -H "Content-Type: application/json" \
 -d '{
 "name": "TestName",
 "count": 5
 }'

     * @param message
     * @return
     */
    @PostMapping("/v2/send")
    public String sendMessageV2(@RequestBody MessageDto message){
        messageProducer.sendMessage(message);
        return "Message sent: " + message;
    }
}
