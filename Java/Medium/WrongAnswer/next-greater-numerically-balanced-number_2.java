class Solution {
    public int nextBeautifulNumber(int n) {
        
        char[] digits = String.valueOf(n).toCharArray();
        int[] counts = new int[10];
        for (int i = 0; i < digits.length; i++) {
            counts[digits[i] - '0']++;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                continue;
            }
            counts[i]--;
            int sum = 0;
            for (int j = 0; j < counts.length; j++) {
                sum += counts[j];
            }
            if (sum <= i) {
                counts[i]++;
                continue;
            }
            int j = 0;
            while (j < counts.length && counts[j] == 0) {
                j++;
            }
            counts[j]++;
            for (int k = 0; k < i + 1; k++) {
                counts[k]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < counts.length; k++) {
                while (counts[k] > 0) {
                    sb.append(k);
                    counts[k]--;
                }
            }
            return Integer.parseInt(sb.toString());
        }
        return -1;
    }
}