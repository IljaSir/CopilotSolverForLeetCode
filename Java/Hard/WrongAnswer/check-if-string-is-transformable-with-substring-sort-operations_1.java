class Solution {
    public boolean isTransformable(String s, String t) {
        
        int n = s.length();
        int[] pos = new int[10];
        for (int i = 0; i < n; i++) {
            pos[s.charAt(i) - '0'] = i;
        }
        for (int i = 0; i < n; i++) {
            int d = t.charAt(i) - '0';
            for (int j = 0; j < d; j++) {
                if (pos[j] < pos[d]) {
                    return false;
                }
            }
            pos[d]++;
        }
        return true;
    }
}