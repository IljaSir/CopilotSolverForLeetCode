class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        
        if (nums.length % k != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (map.size() > 0) {
            int first = map.firstKey();
            for (int i = 0; i < k; i++) {
                if (!map.containsKey(first + i)) {
                    return false;
                }
                int count = map.get(first + i);
                if (count == 1) {
                    map.remove(first + i);
                } else {
                    map.put(first + i, count - 1);
                }
            }
        }
        return true;
    }
}