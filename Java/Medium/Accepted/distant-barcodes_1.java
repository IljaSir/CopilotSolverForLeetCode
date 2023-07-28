class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        int n = barcodes.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int key : map.keySet()) {
            pq.offer(new int[] {key, map.get(key)});
        }
        int[] res = new int[n];
        int i = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            while (cur[1] > 0) {
                res[i] = cur[0];
                cur[1]--;
                i += 2;
                if (i >= n) {
                    i = 1;
                }
            }
        }
        return res;
    }
}