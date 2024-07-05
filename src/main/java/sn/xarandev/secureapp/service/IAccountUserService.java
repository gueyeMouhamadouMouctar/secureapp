package sn.xarandev.secureapp.service;

import java.util.List;
import java.util.Optional;

import sn.xarandev.secureapp.dto.AccountUserDto;
import sn.xarandev.secureapp.entities.AccountUserEntity;

public interface IAccountUserService {
	
	public boolean save(AccountUserDto accountUserDto) ;
	public boolean delete(int id) ;
	public boolean deactivate(int id) ;
	public boolean update(AccountUserDto accountUserDto) ;
	public AccountUserDto getAccount(int id) ;
	
	public List<AccountUserDto> getAll() ;
	
	public Optional<AccountUserDto> login(String email, String password) ;

}
