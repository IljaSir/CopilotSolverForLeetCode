class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        int max = 0;
        int n = answerKey.length();
        int[] count = new int[2];
        int[] count2 = new int[2];
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && (count[0] < k || count[1] < k || (count[0] == k && count[1] == k && (answerKey.charAt(j) == 'T' || answerKey.charAt(j) == 'F')))) {
                if (answerKey.charAt(j) == 'T') {
                    count[0]++;
                } else {
                    count[1]++;
                }
                j++;
            }
            max = Math.max(max, j - i);
            if (answerKey.charAt(i) == 'T') {
                count[0]--;
            } else {
                count[1]--;
            }
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && (count2[0] < k || count2[1] < k || (count2[0] == k && count2[1] == k && (answerKey.charAt(j) == 'F' || answerKey.charAt(j) == 'T')))) {
                if (answerKey.charAt(j) == 'F') {
                    count2[0]++;
                } else {
                    count2[1]++;
                }
                j++;
            }
            max = Math.max(max, j - i);
            if (answerKey.charAt(i) == 'F') {
                count2[0]--;
            } else {
                count2[1]--;
            }
        }
        return max;
    }
}