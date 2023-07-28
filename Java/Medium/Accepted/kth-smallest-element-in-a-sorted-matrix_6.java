class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n-1][n-1];
        while(l < r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                cnt += upper_bound(matrix[i], mid);
            }
            if(cnt < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    
    public int upper_bound(int[] arr, int x) {
        int l = 0;
        int r = arr.length;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] <= x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}