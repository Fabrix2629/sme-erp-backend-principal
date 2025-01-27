package proy.backend.proyClients;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import proy.backend.proyClients.entity.EntityUsuarios.PermissionEntity;
import proy.backend.proyClients.entity.EntityUsuarios.RoleEntity;
import proy.backend.proyClients.entity.EntityUsuarios.RoleEnum;
import proy.backend.proyClients.entity.EntityUsuarios.UserEntity;
import proy.backend.proyClients.repository.UserRepository;

import java.util.List;
import java.util.Set;


@SpringBootApplication
public class ProyClientsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProyClientsApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			// Create PERMISSIONS
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();

			/* Create ROLES */

			RoleEntity roleAdmin = RoleEntity.builder()
					.rolEnum(RoleEnum.ADMIN)
					.permisionEntities(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.rolEnum(RoleEnum.USER)
					.permisionEntities(Set.of(createPermission, readPermission))
					.build();

			RoleEntity roleInvited = RoleEntity.builder()
					.rolEnum(RoleEnum.INVITED)
					.permisionEntities(Set.of(readPermission))
					.build();

			RoleEntity roleDeveloper = RoleEntity.builder()
					.rolEnum(RoleEnum.DEVELOPER)
					.permisionEntities(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
					.build();


			UserEntity userEdgar = UserEntity.builder()
					.username("Edgar")
					.password("$2a$10$yfxOE06YjmRUZB3I1JJYlOOiDaLsRFbNd2cDvE263mm19YFduPFnK")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userFabrisio = UserEntity.builder()
					.username("Fabrisio")
					.password("$2a$10$yfxOE06YjmRUZB3I1JJYlOOiDaLsRFbNd2cDvE263mm19YFduPFnK")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			UserEntity userFreddy = UserEntity.builder()
					.username("Freddy")
					.password("$2a$10$yfxOE06YjmRUZB3I1JJYlOOiDaLsRFbNd2cDvE263mm19YFduPFnK")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();

			UserEntity userInvitado = UserEntity.builder()
					.username("INVITADO")
					.password("$2a$10$yfxOE06YjmRUZB3I1JJYlOOiDaLsRFbNd2cDvE263mm19YFduPFnK")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();

			userRepository.saveAll(List.of(userEdgar, userFabrisio, userFreddy, userInvitado));
		};
	}


}
