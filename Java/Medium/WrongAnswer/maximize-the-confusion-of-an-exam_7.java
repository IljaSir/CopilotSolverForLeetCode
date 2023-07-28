class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        int[] count = new int[2];
        int[] index = new int[2];
        int max = 0;
        for (int i = 0; i < answerKey.length(); ++i) {
            int c = answerKey.charAt(i) == 'T' ? 0 : 1;
            count[c]++;
            if (count[c] > k) {
                count[answerKey.charAt(index[c]) == 'T' ? 0 : 1]--;
                index[c]++;
            }
            max = Math.max(max, i - index[c] + 1);
        }
        return max;
    }
}