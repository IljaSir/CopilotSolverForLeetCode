class Solution {
    public int findLUSlength(String[] strs) {
        
        int n = strs.length;
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (isSubsequence(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return strs[i].length();
            }
        }
        return -1;
    }
    boolean isSubsequence(String a, String b) {
        int n = a.length();
        int m = b.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}