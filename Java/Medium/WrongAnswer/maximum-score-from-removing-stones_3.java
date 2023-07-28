class Solution {
    public int maximumScore(int a, int b, int c) {
        
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        int ans = 0;
        while (arr[0] > 0 && arr[1] > 0) {
            arr[0]--;
            arr[1]--;
            ans++;
        }
        if (arr[0] == 0) {
            ans += (arr[1] + arr[2]) / 2;
        }
        return ans;
    }
}