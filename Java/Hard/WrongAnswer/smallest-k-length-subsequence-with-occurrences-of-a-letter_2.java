class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        
        int n = s.length();
        int[] count = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            count[i] = count[i + 1] + (s.charAt(i) == letter ? 1 : 0);
        }
        int pos = 0;
        int need = repetition;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            char min = 'z' + 1;
            while (pos + k - i <= n) {
                if (count[pos] >= need) {
                    min = s.charAt(pos);
                    break;
                }
                pos++;
            }
            for (int j = pos; j < n; j++) {
                if (s.charAt(j) < min && j + k - i <= n && count[j] >= need) {
                    min = s.charAt(j);
                    pos = j;
                }
            }
            sb.append(min);
            if (min == letter) {
                need--;
            }
            pos++;
        }
        return sb.toString();
    }
}