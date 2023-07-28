class Solution {
    public int findLatestStep(int[] arr, int m) {
        
        int n = arr.length;
        int[] left = new int[n+2], right = new int[n+2];
        int[] group = new int[n+2];
        for(int i=0; i<=n+1; i++) {
            left[i] = i-1;
            right[i] = i+1;
        }
        int ans = -1;
        for(int i=0; i<n; i++) {
            int a = arr[i];
            int len = right[a] - left[a] - 1;
            if(len == m) ans = i;
            group[len]--;
            group[right[a]-left[a]-1]++;
            left[right[a]] = left[a];
            right[left[a]] = right[a];
        }
        return ans;
    }
}