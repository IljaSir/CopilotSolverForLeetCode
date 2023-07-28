class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        if (arr.length % 2 != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        Arrays.sort(nums, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));
        for (int i : nums) {
            if (map.get(i) == 0) {
                continue;
            }
            if (!map.containsKey(2 * i) || map.get(2 * i) == 0) {
                return false;
            }
            map.put(i, map.get(i) - 1);
            map.put(2 * i, map.get(2 * i) - 1);
        }
        return true;
    }
}