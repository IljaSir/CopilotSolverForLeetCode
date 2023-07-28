class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        long mod = sum % k;
        long target = sum / k;
        long ans = 0;
        long[] cnt = new long[(int)k];
        cnt[0] = 1;
        long cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur = (cur + arr[i]) % k;
            if (cur < 0) {
                cur += k;
            }
            long need = (cur - mod + k) % k;
            ans += cnt[(int)need];
            cnt[(int)cur]++;
        }
        return ans;
    }
}