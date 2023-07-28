class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        
        int n = s.length();
        int[] count = new int[n];
        count[n - 1] = s.charAt(n - 1) == letter ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            count[i] = count[i + 1] + (s.charAt(i) == letter ? 1 : 0);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (k > 0) {
            int j = i;
            while (j < n && (n - j + sb.length() >= k) && (count[j] < repetition || s.charAt(j) > letter)) {
                j++;
            }
            if (j == n) {
                sb.append(letter);
                repetition--;
            } else {
                sb.append(s.charAt(j));
                if (s.charAt(j) == letter) {
                    repetition--;
                }
                i = j + 1;
            }
            k--;
        }
        return sb.toString();
    }
}