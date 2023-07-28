class Solution {
    public int distributeCookies(int[] cookies, int k) {
        
        Arrays.sort(cookies);
        int len = cookies.length;
        int minUnfairness = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < len; i++) {
            int max = cookies[i + k - 1];
            int min = cookies[i];
            minUnfairness = Math.min(minUnfairness, max - min);
        }
        return minUnfairness;
    }
}