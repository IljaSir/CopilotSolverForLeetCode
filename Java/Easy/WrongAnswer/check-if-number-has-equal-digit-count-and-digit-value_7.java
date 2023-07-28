class Solution {
    public boolean digitCount(String num) {
        
        if (num.length() == 1) {
            return num.equals("1");
        }
        int[] count = new int[10];
        for (int i = 0; i < num.length(); i++) {
            count[num.charAt(i) - '0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            if (count[digit] != digit) {
                return false;
            }
        }
        return true;
    }
}