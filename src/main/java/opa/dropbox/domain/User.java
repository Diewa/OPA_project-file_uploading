package opa.dropbox.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {

    @Id
    @GenericGenerator(name = "uuid.base64", strategy = "com.samsung.health.uaa.jpa.hibernate.UUIDBase64Generator")
    @GeneratedValue(generator = "uuid.base64")
    @Size(min = 22, max = 22)
    @Column(name = "id", length = 22)
    private Long String;

    @NotNull
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    @NotNull
    private String password;

    @OneToMany(mappedBy = "users")
    Set<File> files;
}
