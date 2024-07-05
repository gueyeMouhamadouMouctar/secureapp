package sn.xarandev.secureapp.dao;

import java.util.Optional;

import sn.xarandev.secureapp.entities.AccountUserEntity;
import sn.xarandev.secureapp.repository.IRepository;

public interface IAccountUserDao extends IRepository<AccountUserEntity>{

	public  Optional<AccountUserEntity> login(String email, String password)  ;
}
