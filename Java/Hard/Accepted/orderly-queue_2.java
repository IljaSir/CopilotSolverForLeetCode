class Solution {
    public String orderlyQueue(String s, int k) {
        
        if (k > 1) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
        String res = s;
        for (int i = 1; i < s.length(); i++) {
            String tmp = s.substring(i) + s.substring(0, i);
            if (tmp.compareTo(res) < 0) {
                res = tmp;
            }
        }
        return res;
    }
}