class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[barcodes.length];
        int index = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int i = 0; i < cur[1]; i++) {
                res[index] = cur[0];
                index += 2;
                if (index >= barcodes.length) {
                    index = 1;
                }
            }
        }
        return res;
    }
}