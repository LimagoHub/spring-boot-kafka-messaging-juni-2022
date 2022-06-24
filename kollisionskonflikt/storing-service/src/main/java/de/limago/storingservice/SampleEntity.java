package de.limago.storingservice;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString


@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "tbldata")
public class SampleEntity {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Version
    private long version;

    @Builder.Default
    private String first = "empty";

    @Builder.Default
    private String second = "empty";
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SampleEntity that = (SampleEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
