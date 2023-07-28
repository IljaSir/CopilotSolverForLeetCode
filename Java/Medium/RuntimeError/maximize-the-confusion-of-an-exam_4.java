class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        int n = answerKey.length();
        int[] count = new int[n];
        int[] count2 = new int[n];
        if (answerKey.charAt(0) == 'T') {
            count[0] = 1;
            count2[0] = 0;
        } else {
            count[0] = 0;
            count2[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (answerKey.charAt(i) == 'T') {
                count[i] = count[i - 1] + 1;
                count2[i] = count2[i - 1];
            } else {
                count[i] = count[i - 1];
                count2[i] = count2[i - 1] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = n;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (count[mid] - count[i] <= k) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            max = Math.max(max, l - i + 1);
        }
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = n;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (count2[mid] - count2[i] <= k) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            max = Math.max(max, l - i + 1);
        }
        return max;
    }
}