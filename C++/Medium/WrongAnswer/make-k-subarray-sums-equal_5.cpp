class Solution {
public:
    long long makeSubKSumEqual(vector<int>& arr, int k) {
        
        long long sum = 0;
        for (int i = 0; i < arr.size(); ++i) {
            sum += arr[i];
        }
        int n = arr.size();
        if (sum % k != 0) return -1;
        long long target = sum / k;
        long long ans = 0;
        long long cur = 0;
        for (int i = 0; i < n; ++i) {
            cur += arr[i];
            if (cur == target) {
                cur = 0;
            } else if (cur > target) {
                ans += cur - target;
                cur = 0;
            }
        }
        return ans;
    }
    int minOperations(vector<int>& arr, int k) {
        int n = arr.size();
        if (k == n) {
            return makeSubKSumEqual(arr, k);
        }
        int ans = 1e9;
        for (int i = 0; i < n; ++i) {
            int l = i;
            int r = (i + k - 1) % n;
            // cout << l << " " << r << endl;
            vector<int> sub;
            if (l <= r) {
                for (int j = l; j <= r; ++j) {
                    sub.push_back(arr[j]);
                }
            } else {
                for (int j = l; j < n; ++j) {
                    sub.push_back(arr[j]);
                }
                for (int j = 0; j <= r; ++j) {
                    sub.push_back(arr[j]);
                }
            }
            // for (int j = 0; j < sub.size(); ++j) {
            //     cout << sub[j] << " ";
            // }
            // cout << endl;
            int cur = makeSubKSumEqual(sub, k);
            if (cur != -1) {
                ans = min(ans, cur);
            }
        }
        return ans;
    }
};