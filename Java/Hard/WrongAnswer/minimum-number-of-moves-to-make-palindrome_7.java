class Solution {
    public int minMovesToMakePalindrome(String s) {
        
        int n = s.length();
        int mid = n / 2;
        int count = 0;
        for (int i = 0; i < mid; i++) {
            int j = n - i - 1;
            int k = i;
            int l = j;
            int min = Integer.MAX_VALUE;
            while (k < l) {
                if (s.charAt(k) == s.charAt(l)) {
                    min = Math.min(min, k - i);
                    break;
                }
                k++;
                l--;
            }
            if (k >= l) {
                count += (j - i);
            } else {
                count += min;
            }
        }
        return count;
    }
}