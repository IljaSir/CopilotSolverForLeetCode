class Solution {
    public boolean checkString(String s) {
        
        int a = 0;
        int b = 0;
        for (char c: s.toCharArray()) {
            if (c == 'a') {
                a++;
            } else {
                b++;
            }
            if (b > a) {
                return false;
            }
        }
        return true;
    }
}