class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        
        if (nums.length % k != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (map.size() > 0) {
            int start = map.firstKey();
            for (int i = start; i < start + k; i++) {
                if (!map.containsKey(i)) return false;
                if (map.get(i) == 1) map.remove(i);
                else map.put(i, map.get(i) - 1);
            }
        }
        return true;
    }
}