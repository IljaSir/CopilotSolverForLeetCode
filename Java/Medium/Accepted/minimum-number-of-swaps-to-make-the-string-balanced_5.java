class Solution {
    public int minSwaps(String s) {
        
        int l = 0;
        int r = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                l++;
            } else {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        return (r + 1) / 2;
    }
}