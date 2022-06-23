package de.limago.storingservice;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "tbl_kredit_antraege")
public class SampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private long version;

    @Builder.Default
    private String first = "empty";

    @Builder.Default
    private String second = "empty";
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

}
