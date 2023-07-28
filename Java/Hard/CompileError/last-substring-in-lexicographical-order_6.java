class Solution {
    public String lastSubstring(String s) {
        
        int n = s.length();
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> s.charAt(a) - s.charAt(b));
        int i = 0;
        int j = 1;
        while (j < n) {
            while (j < n && s.charAt(indices[i] + j - i) == s.charAt(indices[j] + j - i)) {
                j++;
            }
            if (j < n) {
                if (s.charAt(indices[i] + j - i) < s.charAt(indices[j] + j - i)) {
                    i = j;
                }
                j++;
            }
        }
        return s.substring(indices[i]);
    }
}