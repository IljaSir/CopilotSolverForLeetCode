class Solution {
    public String customSortString(String order, String s) {
        
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); ++i) {
            while (cnt[order.charAt(i) - 'a'] > 0) {
                sb.append(order.charAt(i));
                --cnt[order.charAt(i) - 'a'];
            }
        }
        for (int i = 0; i < 26; ++i) {
            while (cnt[i] > 0) {
                sb.append((char)('a' + i));
                --cnt[i];
            }
        }
        return sb.toString();
    }
}