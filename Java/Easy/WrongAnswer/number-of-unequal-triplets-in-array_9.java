class Solution {
    public int unequalTriplets(int[] nums) {
        
        int ans = 0;
        int[] arr = new int[1001];
        for (int num : nums) {
            arr[num]++;
        }
        for (int i = 1; i < 1001; i++) {
            if (arr[i] == 0) continue;
            for (int j = i + 1; j < 1001; j++) {
                if (arr[j] == 0) continue;
                for (int k = j + 1; k < 1001; k++) {
                    if (arr[k] == 0) continue;
                    ans++;
                }
            }
        }
        return ans;
    }
}