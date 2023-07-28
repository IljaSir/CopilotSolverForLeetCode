class Solution {
    public int[] frequencySort(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Integer[] sorted = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted, (a, b) -> {
            int countA = map.get(a);
            int countB = map.get(b);
            if (countA != countB) {
                return countA - countB;
            }
            return b - a;
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sorted[i];
        }
        return nums;
    }
}