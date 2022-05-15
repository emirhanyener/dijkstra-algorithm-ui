package utils;

public class NodeActionListIterator {
	private NodeActionList listFirst;
	private NodeActionList list;
	public NodeActionListIterator(NodeActionList _list) {
		listFirst = _list.next;
		list = _list.next;
	}
	
	public void Next() {
		list = list.next;
	}
	
	public NodeActionList Current() {
		return list;
	}
	
	public void ResetIterator() {
		list = listFirst;
	}
}
