class Solution {
    public int distributeCookies(int[] cookies, int k) {
        
        Arrays.sort(cookies);
        int unfairness = Integer.MAX_VALUE;
        for(int i = 0; i < cookies.length - k + 1; i++){
            int sum = 0;
            for(int j = 0; j < k; j++){
                sum += cookies[i + j];
            }
            unfairness = Math.min(unfairness, sum - cookies[i] * k);
        }
        return unfairness;
    }
}