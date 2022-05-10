package dijkstra_algorithm_graphical;

public interface INodeClickAction {
	public void SetTarget(Node node);
	public void SetStart(Node node);
	public void ChangeNodeBlock(Node node);
	public void ShowNodeInfo(Node node);
	public void StepByStep();
	public void ResetAll();
}