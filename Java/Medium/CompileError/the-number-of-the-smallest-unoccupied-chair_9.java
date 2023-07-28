class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int n = times.length;
        int[] chair = new int[n];
        Arrays.fill(chair, -1);
        int[] next = new int[n];
        Arrays.fill(next, -1);
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = i;
        }
        Arrays.sort(pos, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return times[a][0] - times[b][0];
            }
        });
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[pos[i]] = i;
        }
        int[] heap = new int[n];
        int heapSize = 0;
        for (int i = 0; i < n; i++) {
            int j = pos[i];
            int t = times[j][0];
            while (heapSize > 0 && times[heap[0]][1] <= t) {
                int k = heap[0];
                pop(heap, heapSize--);
                if (next[k] != -1) {
                    prev[next[k]] = prev[k];
                }
                if (prev[k] != -1) {
                    next[prev[k]] = next[k];
                } else {
                    chair[k] = next[k];
                }
            }
            if (j == targetFriend) {
                return chair[order[j]] == -1 ? heapSize : chair[order[j]];
            }
            int x = heapSize++;
            heap[x] = order[j];
            while (x > 0) {
                int y = (x - 1) >> 1;
                if (times[heap[y]][1] > times[heap[x]][1]) {
                    int tmp = heap[y];
                    heap[y] = heap[x];
                    heap[x] = tmp;
                    x = y;
                } else {
                    break;
                }
            }
            if (chair[order[j]] == -1) {
                if (heapSize > 1) {
                    int k = heap[1];
                    if (times[k][1] < times[heap[0]][1]) {
                        int tmp = heap[0];
                        heap[0] =
    }
}