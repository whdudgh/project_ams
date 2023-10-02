package ezen.ams.domain;

import java.io.File;

public class FileAccountRepository implements AccountRepository {

	File file;
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Account[] getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account searchAccount(String accountNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account[] searchAccountByOwner(String accountOwner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAccount(String accountNum) {
		// TODO Auto-generated method stub
		return false;
	}

}
