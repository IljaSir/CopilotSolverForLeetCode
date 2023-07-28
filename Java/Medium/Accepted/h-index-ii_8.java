class Solution {
    public int hIndex(int[] citations) {
        
        int n = citations.length;
        if (n == 0) {
            return 0;
        }
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] >= n - mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return n - l;
    }
}