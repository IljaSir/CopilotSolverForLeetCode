class Solution {
public:
    int threeSumMulti(vector<int>& arr, int target) {
        
        int n = arr.size();
        int mod = 1e9 + 7;
        long long res = 0;
        sort(arr.begin(), arr.end());
        for (int i = 0; i < n; ++i) {
            int t = target - arr[i];
            int l = i + 1, r = n - 1;
            while (l < r) {
                if (arr[l] + arr[r] < t) {
                    ++l;
                } else if (arr[l] + arr[r] > t) {
                    --r;
                } else if (arr[l] != arr[r]) {
                    int left = 1, right = 1;
                    while (l + 1 < r && arr[l] == arr[l + 1]) {
                        ++l;
                        ++left;
                    }
                    while (r - 1 > l && arr[r] == arr[r - 1]) {
                        --r;
                        ++right;
                    }
                    res += left * right;
                    res %= mod;
                    ++l;
                    --r;
                } else {
                    res += (r - l + 1) * (r - l) / 2;
                    res %= mod;
                    break;
                }
            }
        }
        return res;
    }
};