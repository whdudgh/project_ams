package ezen.ams.domain;

/**
 * 메모리(배열)를 이용한 은행계좌 목록 저장 및 관리(검색, 수정, 삭제) 구현체
 * 
 * @author 조영호
 * @author 조영호
 * @since 1.0
 */
public class MemoryAccountRepository implements AccountRepository{

	private Account[] accounts;
	protected int count;

	public MemoryAccountRepository() {
		this(100);
	}

	public MemoryAccountRepository(int capacity) {
		this.accounts = new Account[capacity];
	}

	/**
	 * 전체계좌 목록 수 반환
	 * 
	 * @return 목록수
	 */
	public int getCount() {
		return count;
	}

	/**
	 * 
	 * @return 전체계좌 목록
	 */
	public Account[] getAccounts() {
		return accounts;
	}

	/**
	 * 신규계좌 등록
	 * 
	 * @param account 신규계좌
	 * @return 성공여부(등록여부)
	 */
	public boolean addAccount(Account account) {
//		데이터 검증이 필요하지만 편의상 생략
		accounts[count++] = account;
		return true;
	}

	/**
	 * 계좌로 사용자 조회
	 * 
	 * @param accountNum 검색 계좌번호
	 * @return 검색된 계좌
	 */
	public Account searchAccount(String accountNum) {
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountNum().equals(accountNum)) {
				return accounts[i];
			}
		}
		return null;
	}

	/**
	 * 예금주명으로 계좌조회
	 * 
	 * @param accountOwner 검색 예금주명
	 * @return 검색된 계좌목록
	 */
	public Account[] searchAccountByOwner(String accountOwner) {
		int cnt = 0;
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountOwner().equals(accountOwner)) {
				cnt++;
			}
		}
		if (cnt == 0) {
			return null;
		}
		Account[] resultArr = new Account[cnt];
		int cnt2 = 0;
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountOwner().equals(accountOwner)) {
				resultArr[cnt2++] = accounts[i];
			}

		}
		return resultArr;
	}

	/**
	 * 입력된 계좌번호 삭제
	 *  
	 * @param accountNum 삭제할 계좌번호
	 * @return 삭제여부
	 */
	public boolean removeAccount(String accountNum) {
		//1.순차적으로 검사해서 일치하는걸 빼고 2.나머지애들을 앞당김.
		Account tmp = new Account();
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountNum().equals(accountNum)) {
				tmp = accounts[i];
				accounts[i] = null;
			}
		}
		if(tmp.getAccountNum() == null) {
			return false;
		}
		//여기서 false받은 애들은 해당계좌가 없다는것.
		//여길 통과하면 삭제가 이루어 진거기 때문에 null값이랑 비교해서 정렬함.
		for(int i = 0; i< count; i++) {
			if(accounts[i] == null) {
				tmp = accounts[i];
				accounts[i]=accounts[i+1];
				accounts[i+1]=tmp;
			}
		}
		count--;
		return true;
	}
}