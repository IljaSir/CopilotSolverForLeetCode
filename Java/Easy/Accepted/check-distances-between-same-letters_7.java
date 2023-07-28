class Solution {
    public boolean checkDistances(String s, int[] distance) {
        
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) {
            last[i] = -1;
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (last[c] != -1 && i - last[c] - 1 != distance[c]) {
                return false;
            }
            last[c] = i;
        }
        return true;
    }
}