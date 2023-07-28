class Solution {
    public int getLucky(String s, int k) {
        
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            str += (s.charAt(i) - 'a' + 1);
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < str.length(); j++) {
                sum += str.charAt(j) - '0';
            }
            str = String.valueOf(sum);
            sum = 0;
        }
        return Integer.valueOf(str);
    }
}