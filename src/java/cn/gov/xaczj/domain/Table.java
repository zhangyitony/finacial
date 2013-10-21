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
	 private int planTimeNo;//存储计划表中的记录号
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


	public int getReceivePost() {
		return receivePost;
	}

	public void setReceivePost(int receivePost) {
		this.receivePost = receivePost;
	}

	public int getPlanTimeNo() {
		return planTimeNo;
	}

	public void setPlanTimeNo(int planTimeNo) {
		this.planTimeNo = planTimeNo;
	}

	public Date getPlanTime() {
		return planTime;
	}

	public void setPlanTime(Date planTime) {
		this.planTime = planTime;
	}

	


 }