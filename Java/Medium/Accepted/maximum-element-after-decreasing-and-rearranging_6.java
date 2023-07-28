class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        
        int[] cnt = new int[arr.length + 1];
        for (int a : arr) {
            cnt[Math.min(a, arr.length)]++;
        }
        int miss = 0;
        for (int i = 1; i <= arr.length; ++i) {
            if (cnt[i] == 0) {
                miss++;
            } else {
                miss -= Math.min(cnt[i] - 1, miss);
            }
        }
        return arr.length - miss;
    }
}