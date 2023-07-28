class Solution {
    public String customSortString(String order, String s) {
        
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (counts[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            while (counts[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}