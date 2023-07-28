class Solution {
    public String orderlyQueue(String s, int k) {
        
        if(k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        String res = s;
        for(int i = 1; i < s.length(); i++) {
            String newStr = s.substring(i) + s.substring(0, i);
            if(newStr.compareTo(res) < 0) {
                res = newStr;
            }
        }
        return res;
    }
}