class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> res = new ArrayList<Integer>();
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        int count1 = 0, count2 = 0;
        int candidate1 = nums[0], candidate2 = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate1) {
                count1++;
                continue;
            }
            if (nums[i] == candidate2) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
                continue;
            }
            if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate1) {
                count1++;
            }
            if (nums[i] == candidate2) {
                count2++;
            }
        }
        if (count1 > n / 3) {
            res.add(candidate1);
        }
        if (count2 > n / 3) {
            res.add(candidate2);
        }
        return res;
    }
}