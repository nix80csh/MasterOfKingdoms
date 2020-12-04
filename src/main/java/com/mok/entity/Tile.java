package com.mok.entity;
// Generated 2015. 12. 2 ���� 3:14:23 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tile generated by hbm2java
 */
@Entity
@Table(name = "Tile", schema = "dbo", catalog = "MOK")
public class Tile implements java.io.Serializable {

	private int idfTile;
	private String name;
	private char type;
	private Date regDate;
	private Set<CellTile> cellTiles = new HashSet<CellTile>(0);

	public Tile() {
	}

	public Tile(int idfTile, String name, char type, Date regDate) {
		this.idfTile = idfTile;
		this.name = name;
		this.type = type;
		this.regDate = regDate;
	}

	public Tile(int idfTile, String name, char type, Date regDate, Set<CellTile> cellTiles) {
		this.idfTile = idfTile;
		this.name = name;
		this.type = type;
		this.regDate = regDate;
		this.cellTiles = cellTiles;
	}

	@Id

	@Column(name = "IDF_Tile", unique = true, nullable = false)
	public int getIdfTile() {
		return this.idfTile;
	}

	public void setIdfTile(int idfTile) {
		this.idfTile = idfTile;
	}

	@Column(name = "Name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Type", nullable = false, length = 1)
	public char getType() {
		return this.type;
	}

	public void setType(char type) {
		this.type = type;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RegDate", nullable = false, length = 23)
	public Date getRegDate() {
		return this.regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tile")
	public Set<CellTile> getCellTiles() {
		return this.cellTiles;
	}

	public void setCellTiles(Set<CellTile> cellTiles) {
		this.cellTiles = cellTiles;
	}

}