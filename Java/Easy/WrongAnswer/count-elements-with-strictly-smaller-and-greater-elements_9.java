class Solution {
    public int countElements(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[200001];
        for (int num : nums) {
            count[num + 100000]++;
        }
        int res = 0;
        for (int i = 1; i < count.length - 1; i++) {
            if (count[i] > 0 && count[i - 1] > 0 && count[i + 1] > 0) {
                res += count[i];
            }
        }
        return res;
    }
}