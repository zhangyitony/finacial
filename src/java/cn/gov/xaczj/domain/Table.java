package cn.gov.xaczj.domain;

 import cn.gov.xaczj.domain.CustomizableEntity;
 import java.util.Date;
 
 
 public class Table extends CustomizableEntity {

	 private int id;
	 private Date initFillTime;
	 private int initFillPost;
	 private int inChargePost;
	 private int receivePost;
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

	public int getInitFillPost() {
		return initFillPost;
	}

	public void setInitFillPost(int initFillPost) {
		this.initFillPost = initFillPost;
	}

	public int getInChargePost() {
		return inChargePost;
	}

	public void setInChargePost(int inChargePost) {
		this.inChargePost = inChargePost;
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

	public int getReceivePost() {
		return receivePost;
	}

	public void setReceivePost(int receivePost) {
		this.receivePost = receivePost;
	}

	


 }