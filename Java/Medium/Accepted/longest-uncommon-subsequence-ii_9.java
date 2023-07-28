class Solution {
    public int findLUSlength(String[] strs) {
        
        // 1. sort by length
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String a, String b) {
                return b.length() - a.length();
            }
        });
        
        // 2. check if any string is unique
        for (int i = 0; i < strs.length; i++) {
            if (i == strs.length - 1 || !strs[i].equals(strs[i + 1])) {
                // check if any other string is a subsequence of current string
                int j = 0;
                for (j = 0; j < strs.length; j++) {
                    if (i != j && isSubsequence(strs[i], strs[j])) {
                        break;
                    }
                }
                if (j == strs.length) {
                    return strs[i].length();
                }
            } else {
                // skip same string
                i++;
            }
        }
        return -1;
    }
    
    private boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == a.length();
    }
}