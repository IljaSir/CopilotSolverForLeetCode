class Solution {
    public int numRabbits(int[] answers) {
        
        if (answers == null || answers.length == 0) {
            return 0;
        }
        int[] count = new int[1000];
        for (int a : answers) {
            count[a]++;
        }
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            if (count[i] > 0) {
                result += (count[i] / (i + 1)) * (i + 1);
                if (count[i] % (i + 1) > 0) {
                    result += i + 1;
                }
            }
        }
        return result;
    }
}