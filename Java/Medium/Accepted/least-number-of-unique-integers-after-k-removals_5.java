class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i : map.keySet()) {
            pq.add(new int[] {i, map.get(i)});
        }
        while (k > 0) {
            int[] temp = pq.poll();
            if (temp[1] <= k) {
                k -= temp[1];
            } else {
                pq.add(new int[] {temp[0], temp[1] - k});
                k = 0;
            }
        }
        return pq.size();
    }
}