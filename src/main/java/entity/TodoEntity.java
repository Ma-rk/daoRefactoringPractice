package entity;

public class TodoEntity {
	long tid;
	long assigner_id;
	long pid;
	String title;
	String contents;
	String dueDate;
	String complete;

	// for todo creation
	public TodoEntity(long assigner_id, long pid, String title, String contents, String dueDate) {
		this.assigner_id = assigner_id;
		this.pid = pid;
		this.title = title;
		this.contents = contents;
		this.dueDate = dueDate;
	}

	// for exiting todo modification
	public TodoEntity(long tid, long assigner_id, long pid, String title, String contents, String dueDate, String complete, String last_editer_id) {
		this.tid = tid;
		this.assigner_id = assigner_id;
		this.pid = pid;
		this.title = title;
		this.contents = contents;
		this.dueDate = dueDate;
		this.complete = complete;
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public long getAssigner_id() {
		return assigner_id;
	}

	public long getPid() {
		return pid;
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public String getDueDate() {
		return dueDate;
	}

	public String getComplete() {
		return complete;
	}

	@Override
	public String toString() {
		return "TodoEntity [tid=" + tid + ", assigner_id=" + assigner_id + ", pid=" + pid + ", title=" + title + ", contents=" + contents + ", dueDate=" + dueDate
				+ ", complete=" + complete + "]";
	}
}