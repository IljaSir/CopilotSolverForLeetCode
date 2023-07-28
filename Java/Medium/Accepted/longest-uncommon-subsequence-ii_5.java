class Solution {
    public int findLUSlength(String[] strs) {
        
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean flag = false;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (isSub(strs[i], strs[j])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                max = Math.max(max, strs[i].length());
            }
        }
        return max;
    }
    
    public boolean isSub(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s1.length();
    }
}