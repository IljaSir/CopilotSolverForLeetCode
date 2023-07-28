class Solution {
    public int minSwaps(String s) {
        
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                res++;
                count += 2;
            }
        }
        return res;
    }
}