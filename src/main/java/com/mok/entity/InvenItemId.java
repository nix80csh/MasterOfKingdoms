package com.mok.entity;
// Generated 2015. 12. 2 ���� 3:14:23 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InvenItemId generated by hbm2java
 */
@Embeddable
public class InvenItemId implements java.io.Serializable {

	private int idfAccount;
	private int idfInvenItem;

	public InvenItemId() {
	}

	public InvenItemId(int idfAccount, int idfInvenItem) {
		this.idfAccount = idfAccount;
		this.idfInvenItem = idfInvenItem;
	}

	@Column(name = "IDF_Account", nullable = false)
	public int getIdfAccount() {
		return this.idfAccount;
	}

	public void setIdfAccount(int idfAccount) {
		this.idfAccount = idfAccount;
	}

	@Column(name = "IDF_Inven_Item", nullable = false)
	public int getIdfInvenItem() {
		return this.idfInvenItem;
	}

	public void setIdfInvenItem(int idfInvenItem) {
		this.idfInvenItem = idfInvenItem;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InvenItemId))
			return false;
		InvenItemId castOther = (InvenItemId) other;

		return (this.getIdfAccount() == castOther.getIdfAccount())
				&& (this.getIdfInvenItem() == castOther.getIdfInvenItem());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdfAccount();
		result = 37 * result + this.getIdfInvenItem();
		return result;
	}

}
