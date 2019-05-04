package zp.entity;

public class LiuYan {
	private int liuyan_id;
	private String name;
	private String message;

	public int getLiuyan_id() {
		return liuyan_id;
	}

	public void setLiuyan_id(int liuyan_id) {
		this.liuyan_id = liuyan_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LiuYan [liuyan_id=" + liuyan_id + ", name=" + name + ", message=" + message + "]";
	}

}
