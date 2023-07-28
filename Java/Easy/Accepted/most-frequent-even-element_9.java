class Solution {
    public int mostFrequentEven(int[] nums) {
        
        int[] counts = new int[100001];
        int maxCount = 0;
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 0) {
                counts[num]++;
                if (maxCount < counts[num]) {
                    maxCount = counts[num];
                    minNum = num;
                } else if (maxCount == counts[num]) {
                    minNum = Math.min(minNum, num);
                }
            }
        }
        return minNum == Integer.MAX_VALUE ? -1 : minNum;
    }
}