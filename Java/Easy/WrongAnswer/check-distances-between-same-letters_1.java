class Solution {
    public boolean checkDistances(String s, int[] distance) {
        
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (i - last[c] < distance[c]) {
                return false;
            }
            last[c] = i;
        }
        return true;
    }
}