class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        int sum = 0;
        for(int q: quantities) sum += q;
        int l = 0, r = sum;
        while(l < r) {
            int mid = (l + r) / 2;
            if(check(quantities, mid, n)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    private boolean check(int[] quantities, int x, int n) {
        int sum = 0;
        for(int q: quantities) {
            sum += (q + x - 1) / x;
        }
        return sum <= n;
    }
}