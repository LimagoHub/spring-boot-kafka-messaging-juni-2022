package de.limago.firstsupportingservice;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SampleEntity {

    private long id;


    private long version;

    @Builder.Default
    private String first = "empty";

    @Builder.Default
    private String second = "empty";
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

}
