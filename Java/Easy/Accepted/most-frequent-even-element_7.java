class Solution {
    public int mostFrequentEven(int[] nums) {
        
        int[] count = new int[100001];
        int max = 0;
        int maxIndex = -1;
        for (int num : nums) {
            if (num % 2 == 0) {
                count[num]++;
                if (count[num] > max) {
                    max = count[num];
                    maxIndex = num;
                } else if (count[num] == max && num < maxIndex) {
                    maxIndex = num;
                }
            }
        }
        return maxIndex;
    }
}