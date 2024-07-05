package sn.xarandev.secureapp.service;

import java.util.List;
import java.util.Optional;

import sn.xarandev.secureapp.dao.AccountUserDao;
import sn.xarandev.secureapp.dao.IAccountUserDao;
import sn.xarandev.secureapp.dto.AccountUserDto;
import sn.xarandev.secureapp.entities.AccountUserEntity;
import sn.xarandev.secureapp.mapper.AccountUserMapper;

public class AccountUserService implements IAccountUserService {
	
	public IAccountUserDao dao = new AccountUserDao() ;

	@Override
	public boolean save(AccountUserDto accountUserDto) {
		
		return dao.save(AccountUserMapper.toAccountUserEntity(accountUserDto)) ;
	}

	@Override
	public List<AccountUserDto> getAll() {
		
		
		return AccountUserMapper.listAccountUserEntityToAccountUserDto(dao.list(new AccountUserEntity()));
	}

	@Override
	public Optional<AccountUserDto> login(String email, String password) {

		Optional<AccountUserEntity> accountUserEntity = dao.login(email, password) ;
		if (accountUserEntity.isPresent()){
			
			AccountUserEntity account =  accountUserEntity.get() ;
			return Optional.ofNullable(AccountUserMapper.toAccountUserDto(account)) ;
			
		}else {
			
			return Optional.empty() ;
		}
	}

	@Override
	public boolean delete(int id) {
		System.err.println("____________________    id => " + id);
		try {
			dao.delete(id, new AccountUserEntity()) ;
			return true ;
		} catch (Exception e) {
			return false ;
		}
	}

	@Override
	public AccountUserDto getAccount(int id) {
		// TODO Auto-generated method stub
		
		return AccountUserMapper.toAccountUserDto(dao.get(id, new AccountUserEntity()));
	}

	@Override
	public boolean update(AccountUserDto accountUserDto) {
		
		return dao.update(AccountUserMapper.toAccountUserEntity(accountUserDto));
	}

	@Override
	public boolean deactivate(int id) {
		
		AccountUserDto accountUserDto = getAccount(id);
		
		if(accountUserDto.isState() == true) {
			accountUserDto.setState(false);
		}else {
			accountUserDto.setState(true);
		}
				
		return update(accountUserDto);
	}

}
