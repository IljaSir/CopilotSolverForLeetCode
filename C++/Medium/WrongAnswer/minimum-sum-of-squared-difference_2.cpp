class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        
        int n = nums1.size();
        vector<int> diff(n);
        for (int i = 0; i < n; ++i) {
            diff[i] = nums1[i] - nums2[i];
        }
        sort(diff.begin(), diff.end());
        auto getSum = [&](int k) {
            long long sum = 0;
            for (int i = 0; i < n; ++i) {
                int d = diff[i];
                if (d < 0) {
                    if (k > 0) {
                        sum += 1LL * d * d;
                        --k;
                    } else {
                        sum += 1LL * d * d;
                    }
                } else {
                    if (k > 0) {
                        sum += 1LL * d * d;
                        --k;
                    } else {
                        sum += 1LL * d * d;
                    }
                }
            }
            return sum;
        };
        long long ans = 1e18;
        for (int i = 0; i <= k1; ++i) {
            ans = min(ans, getSum(k2 - k1 + i));
        }
        return ans;
    }
};