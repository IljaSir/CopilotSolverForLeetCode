class Solution {
    public String orderlyQueue(String s, int k) {
        
        if (k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        String ans = s;
        for (int i = 1; i < s.length(); ++i) {
            String t = s.substring(i) + s.substring(0, i);
            if (t.compareTo(ans) < 0) {
                ans = t;
            }
        }
        return ans;
    }
}