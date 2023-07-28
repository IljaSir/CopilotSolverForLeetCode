class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        int n = answerKey.length();
        int max = 0;
        int count = 0;
        int i = 0;
        int j = 0;
        while (j < n) {
            if (answerKey.charAt(j) == 'F') {
                count++;
            }
            if (count > k) {
                if (answerKey.charAt(i) == 'F') {
                    count--;
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        count = 0;
        i = 0;
        j = 0;
        while (j < n) {
            if (answerKey.charAt(j) == 'T') {
                count++;
            }
            if (count > k) {
                if (answerKey.charAt(i) == 'T') {
                    count--;
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}