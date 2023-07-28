class Solution {
    public int hIndex(int[] citations) {
        
        int n = citations.length;
        int lo = 0;
        int hi = n - 1;
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (citations[mid] >= n - mid) {
                ans = n - mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}