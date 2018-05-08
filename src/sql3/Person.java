package sql3;

import java.util.Date;

public class Person {
	private String mName;
	private int mAge;
	private Date mBirthDay;
	private String mSex;

	public String getName() {
		return mName;
	}

	public void setName(String pName) {
		mName = pName;
	}

	public String getSex() {
		return mSex;
	}

	public void setSex(String pSex) {
		mSex = pSex;
	}

	public int getAge() {
		return mAge;
	}

	public void setAge(int pAge) {
		mAge = pAge;
	}

	public Date getBirthDay() {
		return mBirthDay;
	}

	public void setBirthDay(Date pBirthDay) {
		mBirthDay = pBirthDay;
	}

}
