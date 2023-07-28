class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        return Math.max(maxConsecutiveAnswers(answerKey, k, 'T'), maxConsecutiveAnswers(answerKey, k, 'F'));
    }
    
    public int maxConsecutiveAnswers(String answerKey, int k, char c) {
        int i = 0;
        int j = 0;
        int n = answerKey.length();
        int ans = 0;
        int count = 0;
        while (j < n) {
            if (answerKey.charAt(j) == c) {
                count++;
            }
            while (j - i + 1 - count > k) {
                if (answerKey.charAt(i) == c) {
                    count--;
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}