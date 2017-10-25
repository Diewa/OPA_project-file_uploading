package opa.dropbox.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GenericGenerator(name = "uuid.base64", strategy = "com.samsung.health.uaa.jpa.hibernate.UUIDBase64Generator")
    @GeneratedValue(generator = "uuid.base64")
    @Size(min = 22, max = 22)
    @Column(name = "id", length = 22)
    private String id;

    @NotNull
    @Column(name = "path")
    private String path;

    @Column(name = "size")
    private Long size;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
