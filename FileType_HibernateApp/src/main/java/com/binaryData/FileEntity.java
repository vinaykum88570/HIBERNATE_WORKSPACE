package com.binaryData;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="file_table")
public class FileEntity {

	@Id
	String fieName;
	
	String fiteType;
	
	// large object
	@Lob 
	byte[] data;
	
	public FileEntity() {
		
	}

	public FileEntity(String fieName, String fiteType, byte[] data) {
		super();
		this.fieName = fieName;
		this.fiteType = fiteType;
		this.data = data;
	}

	public String getFieName() {
		return fieName;
	}

	public void setFieName(String fieName) {
		this.fieName = fieName;
	}

	public String getFiteType() {
		return fiteType;
	}

	public void setFiteType(String fiteType) {
		this.fiteType = fiteType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
	
	
	
	
}






























