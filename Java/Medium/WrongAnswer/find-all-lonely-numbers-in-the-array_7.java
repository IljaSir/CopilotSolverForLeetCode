class Solution {
    public List<Integer> findLonely(int[] nums) {
        
        List<Integer> lonely = new ArrayList<>();
        int[] count = new int[1000001];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i]] == 1) {
                lonely.add(nums[i]);
            }
        }
        return lonely;
    }
}