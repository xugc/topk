import java.util.Random;

public class HeapMinK {
	private int[] minK;
	private int k;
	private int local = 0;

	public HeapMinK(int k) {
		this.k = k;
		minK = new int[k];
	}

	public int[] insertEl(int el) {
		if (local < k) {
			minK[local] = el;
			local++;
		} else {
			if (el >= minK[0]) {
				minK[0] = el;
			}
		}
		buildHeap();
		return minK;
	}

	private void buildHeap() {
		for (int i = local / 2 - 1; i >= 0; i--) {
			minHeap(i, local - 1);
		}
	}

	private void minHeap(int start, int end) {
		int parent = start;
		int child = 2 * start + 1;
		while (child <= end) {
			if (child + 1 <= end && minK[child + 1] < minK[child]) {
				child++;
			}
			if (minK[parent] <= minK[child])
				return;
			else {
				int tmp = minK[parent];
				minK[parent] = minK[child];
				minK[child] = tmp;
				parent = child;
				child = parent * 2 + 1;
			}
		}
	}

	public static void main(String[] args) {
		HeapMinK hmk = new HeapMinK(10);
		int l = 0;
		Random rdom = new Random(100000);
		while (l < 100000) {
			int[] r = hmk.insertEl(rdom.nextInt(100000));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 10; i++) {
				sb.append(r[i]);
				sb.append(",");
			}
			System.out.println(sb);
			System.out.println("------------------");
			l++;
		}
	}
}
