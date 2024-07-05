package sn.xarandev.secureapp.mapper;

import java.util.List;
import java.util.stream.Collectors;

import sn.xarandev.secureapp.dto.AccountUserDto;
import sn.xarandev.secureapp.entities.AccountUserEntity;

public class AccountUserMapper {
	
	public static List<AccountUserDto> listAccountUserEntityToAccountUserDto(List<AccountUserEntity> accounts) {
		
		return accounts.stream()
							.map(account -> toAccountUserDto(account))
							.collect(Collectors.toList()) ;
	}
	
	public static AccountUserDto toAccountUserDto(AccountUserEntity accountUserEntity) {
		return new AccountUserDto(accountUserEntity.getId(), accountUserEntity.getEmail(), accountUserEntity.getFirstname(), accountUserEntity.getLastname(), accountUserEntity.getProfil(), accountUserEntity.getPassword(), accountUserEntity.isState()) ;
	}
	public static AccountUserEntity toAccountUserEntity(AccountUserDto accountUserDto) {
		
		return new AccountUserEntity(accountUserDto.getId(), accountUserDto.getEmail(), accountUserDto.getFirstname(), accountUserDto.getLastname(), accountUserDto.getProfil(), accountUserDto.getPassword(), accountUserDto.isState()) ;
	}

}
