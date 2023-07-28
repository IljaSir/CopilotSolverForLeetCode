class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int[] cnt = new int[2];
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            cnt[sum % 2]++;
        }
        for (int i = 0; i < arr.length; i++) {
            res += cnt[sum % 2];
            sum -= arr[i];
            cnt[sum % 2]--;
        }
        return res;
    }
}