class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
        for (int n : map.keySet()) {
            queue.add(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            result[i++] = queue.poll();
        }
        return result;
    }
}