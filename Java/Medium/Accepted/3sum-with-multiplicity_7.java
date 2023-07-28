class Solution {
    public int threeSumMulti(int[] arr, int target) {
        
        int mod = (int) 1e9 + 7;
        long res = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int t = target - arr[i];
            int l = i + 1;
            int r = arr.length - 1;
            while (l < r) {
                if (arr[l] + arr[r] < t) {
                    l++;
                } else if (arr[l] + arr[r] > t) {
                    r--;
                } else if (arr[l] != arr[r]) {
                    int left = 1;
                    int right = 1;
                    while (l + 1 < r && arr[l] == arr[l + 1]) {
                        left++;
                        l++;
                    }
                    while (r - 1 > l && arr[r] == arr[r - 1]) {
                        right++;
                        r--;
                    }
                    res += left * right;
                    res %= mod;
                    l++;
                    r--;
                } else {
                    res += (r - l + 1) * (r - l) / 2;
                    res %= mod;
                    break;
                }
            }
        }
        return (int) res;
    }
}