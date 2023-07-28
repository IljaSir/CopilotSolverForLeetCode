class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        int[] counts = new int[10001];
        for (int barcode : barcodes) {
            counts[barcode]++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 10001; i++) {
            if (counts[i] > 0) {
                pq.add(new int[] {i, counts[i]});
            }
        }
        int[] res = new int[barcodes.length];
        int idx = 0;
        while (pq.size() > 1) {
            int[] first = pq.poll();
            int[] second = pq.poll();
            res[idx++] = first[0];
            res[idx++] = second[0];
            if (--first[1] > 0) {
                pq.add(first);
            }
            if (--second[1] > 0) {
                pq.add(second);
            }
        }
        if (!pq.isEmpty()) {
            res[idx] = pq.poll()[0];
        }
        return res;
    }
}