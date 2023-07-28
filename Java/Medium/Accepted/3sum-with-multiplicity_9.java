class Solution {
    public int threeSumMulti(int[] arr, int target) {
        
        // 1. sort array
        Arrays.sort(arr);
        // 2. loop array
        int result = 0;
        int mod = 1000000007;
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) {
                    if (arr[j] == arr[k]) {
                        result += (k - j + 1) * (k - j) / 2;
                        result %= mod;
                        break;
                    } else {
                        int left = 1;
                        int right = 1;
                        while (j + 1 < k && arr[j] == arr[j + 1]) {
                            left++;
                            j++;
                        }
                        while (k - 1 > j && arr[k] == arr[k - 1]) {
                            right++;
                            k--;
                        }
                        result += left * right;
                        result %= mod;
                        j++;
                        k--;
                    }
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}