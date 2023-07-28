class Solution {
    public int distributeCookies(int[] cookies, int k) {
        
        int n = cookies.length;
        Arrays.sort(cookies);
        int unfairness = Integer.MAX_VALUE;
        for (int i = 0; i + k <= n; i++) {
            unfairness = Math.min(unfairness, cookies[i + k - 1] - cookies[i]);
        }
        return unfairness;
    }
}