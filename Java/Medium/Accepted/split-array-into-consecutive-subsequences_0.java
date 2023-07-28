class Solution {
    public boolean isPossible(int[] nums) {
        
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new PriorityQueue<>());
            }
            if (map.containsKey(num - 1)) {
                int prevLength = map.get(num - 1).poll();
                if (map.get(num - 1).isEmpty()) {
                    map.remove(num - 1);
                }
                map.get(num).offer(prevLength + 1);
            } else {
                map.get(num).offer(1);
            }
        }
        for (int key : map.keySet()) {
            PriorityQueue<Integer> queue = map.get(key);
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }
}