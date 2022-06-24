package de.limago.storingservice;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Model {

    @Builder.Default
    private String id = UUID.randomUUID().toString();


    private long version;

    @Builder.Default
    private String first = "empty";

    @Builder.Default
    private String second = "empty";
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
