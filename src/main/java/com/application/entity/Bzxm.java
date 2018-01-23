package com.application.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bzxm {
	@Id
	@GeneratedValue
	private int id;
	private String bzxmtybh;
	private String xmbsm;
	private String xmmc;
	private String xmxz;
	private int ydmj;
	private int jzmj;
	private String xzqh;
	private Date cjsj;
	private Date xgsj;
	private int zt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBzxmtybh() {
		return bzxmtybh;
	}

	public void setBzxmtybh(String bzxmtybh) {
		this.bzxmtybh = bzxmtybh;
	}

	public String getXmbsm() {
		return xmbsm;
	}

	public void setXmbsm(String xmbsm) {
		this.xmbsm = xmbsm;
	}

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public String getXmxz() {
		return xmxz;
	}

	public void setXmxz(String xmxz) {
		this.xmxz = xmxz;
	}

	public int getYdmj() {
		return ydmj;
	}

	public void setYdmj(int ydmj) {
		this.ydmj = ydmj;
	}

	public int getJzmj() {
		return jzmj;
	}

	public void setJzmj(int jzmj) {
		this.jzmj = jzmj;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public Date getCjsj() {
		return cjsj;
	}

	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}

	public Date getXgsj() {
		return xgsj;
	}

	public void setXgsj(Date xgsj) {
		this.xgsj = xgsj;
	}

	public int getZt() {
		return zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}
}
