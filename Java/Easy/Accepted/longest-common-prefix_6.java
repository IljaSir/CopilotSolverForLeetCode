class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs == null || strs.length == 0) {
            return "";
        }
        int n = strs.length;
        int minLen = strs[0].length();
        for (int i = 1; i < n; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        int low = 0, high = minLen;
        while (low < high) {
            int mid = (low + high + 1) >>> 1;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str0 = strs[0].substring(0, len);
        int n = strs.length;
        for (int i = 1; i < n; i++) {
            if (!strs[i].startsWith(str0)) {
                return false;
            }
        }
        return true;
    }
}