class Solution {
public:
    int threeSumMulti(vector<int>& arr, int target) {
        
        int n = arr.size();
        int MOD = 1e9 + 7;
        int ans = 0;
        sort(arr.begin(), arr.end());
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) {
                    if (arr[i] == arr[j] && arr[j] == arr[k]) {
                        ans = (ans + (k - j + 1) * (k - j) / 2) % MOD;
                        break;
                    } else if (arr[i] == arr[j]) {
                        int l = k;
                        while (l > j && arr[l] == arr[k]) {
                            l--;
                        }
                        ans = (ans + (k - l) * (k - l + 1) / 2) % MOD;
                        k = l;
                    } else if (arr[j] == arr[k]) {
                        int l = j;
                        while (l < k && arr[l] == arr[j]) {
                            l++;
                        }
                        ans = (ans + (l - j) * (l - j + 1) / 2) % MOD;
                        j = l;
                    } else {
                        ans = (ans + 1) % MOD;
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
        return ans;
    }
};