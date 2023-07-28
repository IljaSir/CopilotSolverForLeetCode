class Solution {
    public boolean divideArray(int[] nums) {
        
        int[] count = new int[1001];
        for (int num : nums) {
            count[num]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0 && count[i] % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}