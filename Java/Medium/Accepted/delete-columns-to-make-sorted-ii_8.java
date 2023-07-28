class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length;
        int m = strs[0].length();
        boolean[] isSorted = new boolean[n - 1];
        int count = 0;
        for (int j = 0; j < m; j++) {
            boolean isSortedCol = true;
            for (int i = 0; i < n - 1; i++) {
                if (!isSorted[i] && strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    count++;
                    isSortedCol = false;
                    break;
                }
            }
            if (isSortedCol) {
                for (int i = 0; i < n - 1; i++) {
                    if (strs[i].charAt(j) < strs[i + 1].charAt(j)) {
                        isSorted[i] = true;
                    }
                }
            }
        }
        return count;
    }
}