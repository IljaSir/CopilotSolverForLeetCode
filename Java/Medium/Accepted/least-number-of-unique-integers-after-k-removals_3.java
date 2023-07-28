class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(map.size(), (a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(e);
        }
        while (k > 0) {
            Map.Entry<Integer, Integer> e = pq.poll();
            e.setValue(e.getValue() - 1);
            if (e.getValue() > 0) {
                pq.offer(e);
            }
            k--;
        }
        return pq.size();
    }
}