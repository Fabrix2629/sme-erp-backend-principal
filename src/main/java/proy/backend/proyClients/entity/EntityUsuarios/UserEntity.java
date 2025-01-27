package proy.backend.proyClients.entity.EntityUsuarios;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_usuarios")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUserName;

    @Column(unique = true)
    private String username;
    private String password;

    @Column(name = "is_enble")
    private boolean isEnabled;

    @Column(name = "is_accountNoExpired")
    private boolean accountNoExpired;

    @Column(name = "is_accountNoLocked")
    private boolean accountNoLocked;

    @Column(name = "is_credentialNoExpired")
    private boolean credentialNoExpired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "role_permissions", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<RoleEntity> roles = new HashSet<>();

}
