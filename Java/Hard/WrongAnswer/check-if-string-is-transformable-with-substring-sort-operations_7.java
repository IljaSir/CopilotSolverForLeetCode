class Solution {
    public boolean isTransformable(String s, String t) {
        
        if (s.length() != t.length()) return false;
        int[] pos = new int[10];
        Arrays.fill(pos, -1);
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - '0'] = i;
        }
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i) - '0';
            if (pos[c] == -1) return false;
            for (int j = 0; j < c; j++) {
                if (pos[j] > pos[c]) return false;
            }
            pos[c] = -1;
        }
        return true;
    }
}