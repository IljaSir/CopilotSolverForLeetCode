class Solution {
    public int[] frequencySort(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Arrays.sort(nums);
        Arrays.sort(nums, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                int f1 = map.get(i1);
                int f2 = map.get(i2);
                if (f1 != f2) {
                    return f1 - f2;
                } else {
                    return i2 - i1;
                }
            }
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
}