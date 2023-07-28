class Solution {
    public int distributeCookies(int[] cookies, int k) {
        
        Arrays.sort(cookies);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<cookies.length-k+1;i++){
            int unfairness = cookies[i+k-1] - cookies[i];
            min = Math.min(min, unfairness);
        }
        return min;
    }
}