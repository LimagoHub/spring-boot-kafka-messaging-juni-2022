package de.limago.firstsupportingservice.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataEvent <T>{

    @Builder.Default
    private String eventId = UUID.randomUUID().toString();
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
    private T payload;
}
