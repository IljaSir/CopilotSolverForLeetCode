class Solution {
    public int sumOfUnique(int[] nums) {
        
        int sum = 0;
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }
}