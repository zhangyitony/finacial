package cn.gov.xaczj.domain;

 import cn.gov.xaczj.domain.CustomizableEntity;
 import java.util.Date;
 
 
 public class Table extends CustomizableEntity {

	 private int id;
	 private Date initFillTime;
	 private int initFillAcount;
	 private int inChargeAcount;
	 private int receiveAcount;
	 private short status;
	 private Date planTime;
	 public int getId() {
	     return id;
	 }
	
	 public void setId(int id) {
	     this.id = id;
	 }

	public Date getInitFillTime() {
		return initFillTime;
	}

	public void setInitFillTime(Date initFillTime) {
		this.initFillTime = initFillTime;
	}

	public int getInitFillAcount() {
		return initFillAcount;
	}

	public void setInitFillAcount(int initFillAcount) {
		this.initFillAcount = initFillAcount;
	}

	public int getInChargeAcount() {
		return inChargeAcount;
	}

	public void setInChargeAcount(int inChargeAcount) {
		this.inChargeAcount = inChargeAcount;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Date getPlanTime() {
		return planTime;
	}

	public void setPlanTime(Date planTime) {
		this.planTime = planTime;
	}

	public int getReceiveAcount() {
		return receiveAcount;
	}

	public void setReceiveAcount(int receiveAcount) {
		this.receiveAcount = receiveAcount;
	}

	


 }