class Solution {
    public boolean checkDistances(String s, int[] distance) {
        
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (last[c] >= 0 && i - last[c] != distance[c]) {
                return false;
            }
            last[c] = i;
        }
        return true;
    }
}