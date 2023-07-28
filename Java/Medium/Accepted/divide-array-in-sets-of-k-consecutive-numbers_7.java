class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        
        if (nums.length % k != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        while (!map.isEmpty()) {
            int start = map.firstKey();
            for (int i = start; i < start + k; i++) {
                if (!map.containsKey(i)) return false;
                int count = map.get(i);
                if (count == 1) {
                    map.remove(i);
                } else {
                    map.put(i, count - 1);
                }
            }
        }
        return true;
    }
}