class Solution {
    public int distributeCookies(int[] cookies, int k) {
        
        Arrays.sort(cookies);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= cookies.length - k; i++) {
            int max = 0;
            for (int j = 0; j < k; j++) {
                max += cookies[i + j];
            }
            min = Math.min(min, max - cookies[i] * k);
        }
        return min;
    }
}