class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        
        if (nums.length % k != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (map.size() > 0) {
            int key = map.firstKey();
            int value = map.get(key);
            for (int i = 0; i < k; i++) {
                if (map.getOrDefault(key + i, 0) < value) return false;
                if (map.get(key + i) == value) map.remove(key + i);
                else map.put(key + i, map.get(key + i) - value);
            }
        }
        return true;
    }
}