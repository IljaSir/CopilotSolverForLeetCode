class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int j = i + 1;
            while (j < temperatures.length) {
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    break;
                }
                j++;
            }
        }
        return ans;
    }
}