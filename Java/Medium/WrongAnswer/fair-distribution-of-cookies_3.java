class Solution {
    public int distributeCookies(int[] cookies, int k) {
        
        Arrays.sort(cookies);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= cookies.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, cookies[j]);
            }
            min = Math.min(min, max - cookies[i]);
        }
        return min;
    }
}