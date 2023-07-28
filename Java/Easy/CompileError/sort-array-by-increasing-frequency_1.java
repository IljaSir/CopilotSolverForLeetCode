class Solution {
    public int[] frequencySort(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(nums);
        Arrays.sort(nums, (n1, n2) -> map.get(n1) - map.get(n2));
        return nums;
    }
}