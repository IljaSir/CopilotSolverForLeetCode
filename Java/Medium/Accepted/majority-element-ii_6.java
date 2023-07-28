class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return result;
        int n1 = nums[0], n2 = nums[0], c1 = 0, c2 = 0;
        for (int num : nums) {
            if (num == n1) {
                c1++;
            } else if (num == n2) {
                c2++;
            } else if (c1 == 0) {
                n1 = num;
                c1 = 1;
            } else if (c2 == 0) {
                n2 = num;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int num : nums) {
            if (num == n1) c1++;
            else if (num == n2) c2++;
        }
        if (c1 > nums.length / 3) result.add(n1);
        if (c2 > nums.length / 3) result.add(n2);
        return result;
    }
}