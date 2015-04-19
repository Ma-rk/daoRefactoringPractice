package entity;

public class TodoEntity {
	long tid;
	long handlerId;
	long pid;
	String title;
	String contents;
	String dueDate;
	String complete;

	// for todo creation
	public TodoEntity(long handlerId, long pid, String title, String contents, String dueDate) {
		this.handlerId = handlerId;
		this.pid = pid;
		this.title = title;
		this.contents = contents;
		this.dueDate = dueDate;
	}
	
	// for todo creation
	public TodoEntity(long tid, long handlerId, long pid, String title, String contents, String dueDate) {
		this.tid = tid;
		this.handlerId = handlerId;
		this.pid = pid;
		this.title = title;
		this.contents = contents;
		this.dueDate = dueDate;
	}

	// for exiting todo modification
	public TodoEntity(long tid, long handlerId, long pid, String title, String contents, String dueDate, String complete, String last_editer_id) {
		this.tid = tid;
		this.handlerId = handlerId;
		this.pid = pid;
		this.title = title;
		this.contents = contents;
		this.dueDate = dueDate;
		this.complete = complete;
	}

	// for exiting todo completion or deletion
	public TodoEntity(long tid, long handlerId) {
		this.tid = tid;
		this.handlerId = handlerId;
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public long getHandlerId() {
		return handlerId;
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
		return "TodoEntity [tid=" + tid + ", assigner_id=" + handlerId + ", pid=" + pid + ", title=" + title + ", contents=" + contents + ", dueDate=" + dueDate
				+ ", complete=" + complete + "]";
	}
}