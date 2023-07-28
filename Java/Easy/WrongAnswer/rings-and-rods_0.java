class Solution {
    public int countPoints(String rings) {
        
        int[] count = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            count[rings.charAt(i + 1) - '0']++;
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            if (count[i] >= 3) {
                res++;
            }
        }
        return res;
    }
}