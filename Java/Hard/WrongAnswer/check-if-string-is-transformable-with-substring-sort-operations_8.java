class Solution {
    public boolean isTransformable(String s, String t) {
        
        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums[i] = s.charAt(i) - '0';
        }
        int[] pos = new int[10];
        for (int i = 0; i < s.length(); i++) {
            pos[nums[i]] = i;
        }
        for (int i = 0; i < t.length(); i++) {
            int num = t.charAt(i) - '0';
            if (pos[num] == s.length()) {
                return false;
            }
            for (int j = 0; j < num; j++) {
                if (pos[j] < pos[num]) {
                    return false;
                }
            }
            pos[num]++;
        }
        return true;
    }
}