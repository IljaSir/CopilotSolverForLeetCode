class Solution {
    public String orderlyQueue(String s, int k) {
        
        if (k > 1) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            return new String(cs);
        } else {
            String ans = s;
            for (int i = 0; i < s.length(); ++i) {
                String t = s.substring(i) + s.substring(0, i);
                if (t.compareTo(ans) < 0) {
                    ans = t;
                }
            }
            return ans;
        }
    }
}