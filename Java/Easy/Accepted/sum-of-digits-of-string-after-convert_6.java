class Solution {
    public int getLucky(String s, int k) {
        
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            str += (s.charAt(i) - 'a' + 1);
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = 0;
            for (int j = 0; j < str.length(); j++) {
                ans += str.charAt(j) - '0';
            }
            str = "" + ans;
        }
        return ans;
    }
}