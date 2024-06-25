package com.app.springsecurityapp;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.springsecurityapp.persistence.entity.PermissionEntity;
import com.app.springsecurityapp.persistence.entity.RoleEntity;
import com.app.springsecurityapp.persistence.entity.RoleEnum;
import com.app.springsecurityapp.persistence.entity.UserEntity;
import com.app.springsecurityapp.persistence.repository.UserRepository;

@SpringBootApplication
public class SpringsecurityappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityappApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			/* CREATE PERMISSIONS */
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

			// Create ROLES
			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();
			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(createPermission, readPermission))
					.build();
			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionList(Set.of(readPermission))
					.build();
			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionList(
							Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
					.build();

			// CREATE USER
			UserEntity userSantiago = UserEntity.builder()
					.username("santiago")
					.password("$2a$10$EqifEvcn.EnfmGTsMHfkzuU.hOKB2ZtzLshfY40qmf1DQJWIbJ5aG")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userDaniel = UserEntity.builder()
					.username("daniel")
					.password("$2a$10$EqifEvcn.EnfmGTsMHfkzuU.hOKB2ZtzLshfY40qmf1DQJWIbJ5aG")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			UserEntity userAndrea = UserEntity.builder()
					.username("andrea")
					.password("$2a$10$EqifEvcn.EnfmGTsMHfkzuU.hOKB2ZtzLshfY40qmf1DQJWIbJ5aG")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();

			UserEntity userAngie = UserEntity.builder()
					.username("angie")
					.password("1$2a$10$EqifEvcn.EnfmGTsMHfkzuU.hOKB2ZtzLshfY40qmf1DQJWIbJ5aG234")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();

			userRepository.saveAll(List.of(userSantiago, userDaniel, userAndrea, userAngie));

		};

	}
}
