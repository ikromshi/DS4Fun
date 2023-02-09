public class QuickFind {
	private int[] parents;	// keeps track of what site belongs to what component;
	private int count; 		// number of components;

	public QuickFind(int N) {
		count = N;
		parents = new int[N];
		
		// each site is in its own component;
		for (int i=0; i<N; i++) {
			parents[i] = i;
		}
	}

	// returns the number of components;
	public int getCount() {
		return count;
	}

	// checks if two sites are connected;
	public boolean connected(int a, int b) {
		return find(a) == find(b);
	}

	// returns the parent ID of the site;
	public int find(int i) {
		return parents[i];		
	}
	
	// merges two disconnected sites/components;
	public void union(int a, int b) {
		int aID = find(a);
		int bID = find(b);

		// if sites are in the same component, return;
		if (aID == bID) return;

		// change the parent of the merged component;
		for (int i=0; i<parents.length; i++) {
			if (parents[i] == aID) {
				parents[i] = bID;
			}
		}
		
		// component size goes down by one after each union;
		size--;


	public static void main(String[] args) {
				
	}
}
