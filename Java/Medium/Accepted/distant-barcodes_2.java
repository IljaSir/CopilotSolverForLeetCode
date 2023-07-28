class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        int[] count = new int[10001];
        for (int b : barcodes) {
            count[b]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> count[b] - count[a]);
        for (int i = 1; i <= 10000; i++) {
            if (count[i] > 0) {
                pq.add(i);
            }
        }
        int[] ans = new int[barcodes.length];
        int t = 0;
        while (pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();
            ans[t++] = a;
            ans[t++] = b;
            count[a]--;
            count[b]--;
            if (count[a] > 0) {
                pq.add(a);
            }
            if (count[b] > 0) {
                pq.add(b);
            }
        }
        if (pq.size() > 0) {
            ans[t] = pq.poll();
        }
        return ans;
    }
}