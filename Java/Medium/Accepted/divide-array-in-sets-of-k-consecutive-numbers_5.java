class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        
        if (nums.length % k != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (!map.isEmpty()) {
            int first = map.firstKey();
            for (int i = 0; i < k; i++) {
                int next = first + i;
                if (!map.containsKey(next)) return false;
                int count = map.get(next);
                if (count == 1) map.remove(next);
                else map.put(next, count - 1);
            }
        }
        return true;
    }
}