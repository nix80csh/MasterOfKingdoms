package com.mok.entity;
// Generated 2015. 11. 25 ���� 7:29:01 by Hibernate Tools 3.6.0.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * InvenWeapon generated by hbm2java
 */
@Entity
@Table(name = "inven_weapon", schema = "public")
public class InvenWeapon implements java.io.Serializable {

	private InvenWeaponId id;
	private Lord lord;
	private Weapon weapon;
	private Date regDate;

	public InvenWeapon() {
	}

	public InvenWeapon(InvenWeaponId id, Lord lord, Weapon weapon, Date regDate) {
		this.id = id;
		this.lord = lord;
		this.weapon = weapon;
		this.regDate = regDate;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idfLord", column = @Column(name = "idf_lord", nullable = false) ),
			@AttributeOverride(name = "idfInvenWeapon", column = @Column(name = "idf_inven_weapon", nullable = false) ) })
	public InvenWeaponId getId() {
		return this.id;
	}

	public void setId(InvenWeaponId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idf_lord", nullable = false, insertable = false, updatable = false)
	public Lord getLord() {
		return this.lord;
	}

	public void setLord(Lord lord) {
		this.lord = lord;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idf_weapon", nullable = false)
	public Weapon getWeapon() {
		return this.weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reg_date", nullable = false, length = 29)
	public Date getRegDate() {
		return this.regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}
