class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        
        Arrays.sort(special);
        int ans = 0;
        int last = -1;
        for (int i = 0; i < special.length; i++) {
            if (i == 0) {
                ans = Math.max(ans, special[i] - bottom);
            } else {
                ans = Math.max(ans, special[i] - last - 1);
            }
            last = special[i];
        }
        ans = Math.max(ans, top - last);
        return ans;
    }
}