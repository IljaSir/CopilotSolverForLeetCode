class Solution {
public:
    int threeSumMulti(vector<int>& arr, int target) {
        
        int n = arr.size();
        int ans = 0;
        const int mod = 1e9 + 7;
        sort(arr.begin(), arr.end());
        for (int i = 0; i < n; ++i) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) {
                    if (arr[j] == arr[k]) {
                        ans += (k - j + 1) * (k - j) / 2;
                        ans %= mod;
                        break;
                    }
                    else {
                        int l = j + 1, r = k - 1;
                        while (l < r && arr[l] == arr[j]) ++l;
                        while (l < r && arr[r] == arr[k]) --r;
                        ans += (l - j) * (k - r);
                        ans %= mod;
                        j = l;
                        k = r;
                    }
                }
                else if (sum < target) {
                    ++j;
                }
                else {
                    --k;
                }
            }
        }
        return ans;
    }
};