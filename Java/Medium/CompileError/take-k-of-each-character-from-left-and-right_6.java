class Solution {
    public int takeCharacters(String s, int k) {
        
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] count = new int[3];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
            left[i]= count[0];
            right[n - 1 - i] = count[1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i+){
            int l = i + ;
            int r = n - i;
            if (left[i] >= k && right[i] >= k) {
                ans = Math.min(ans, Math.max(l, r)
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}