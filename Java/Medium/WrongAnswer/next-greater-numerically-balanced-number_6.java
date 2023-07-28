class Solution {
    public int nextBeautifulNumber(int n) {
        
        int[] freq = new int[10];
        int tmp = n;
        while (tmp > 0) {
            freq[tmp % 10]++;
            tmp /= 10;
        }
        int[] digits = new int[10];
        int i = 0;
        for (int d = 1; d < 10; d++) {
            while (freq[d] > 0) {
                digits[i++] = d;
                freq[d]--;
            }
        }
        int res = 0;
        for (int j = 0; j < i; j++) {
            res = res * 10 + digits[j];
        }
        return res;
    }
}