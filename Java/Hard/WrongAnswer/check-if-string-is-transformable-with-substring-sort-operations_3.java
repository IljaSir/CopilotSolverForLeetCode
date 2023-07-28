class Solution {
    public boolean isTransformable(String s, String t) {
        
        int[] pos = new int[10];
        Arrays.fill(pos, -1);
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - '0'] = i;
        }
        for (int i = 0; i < t.length(); i++) {
            int num = t.charAt(i) - '0';
            if (pos[num] == -1) {
                return false;
            }
            for (int j = 0; j < num; j++) {
                if (pos[j] != -1 && pos[j] < pos[num]) {
                    return false;
                }
            }
            pos[num] = -1;
        }
        return true;
    }
}