class Solution {
    public boolean checkDistances(String s, int[] distance) {
        
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i - last[c - 'a'] < distance[c - 'a']) {
                return false;
            }
            last[c - 'a'] = i;
        }
        return true;
    }
}