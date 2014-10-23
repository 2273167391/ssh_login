package com.tenghu.ssh.core.test;

import java.util.ArrayList;
import java.util.List;

public class Base {
	private int status;
	private String message;
	private List<FY> data=new ArrayList<Base.FY>();
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<FY> getData() {
		return data;
	}
	public void setData(String dst, String src) {
		this.data.add(new Base.FY(dst, src));
	}
	public class FY{
		private String dst;
		private String src;
		public FY(){}
		public FY(String dst, String src) {
			this.dst = dst;
			this.src = src;
		}
		public String getDst() {
			return dst;
		}
		public void setDst(String dst) {
			this.dst = dst;
		}
		public String getSrc() {
			return src;
		}
		public void setSrc(String src) {
			this.src = src;
		}
	}
}
