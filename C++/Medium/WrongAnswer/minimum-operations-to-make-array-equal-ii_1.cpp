class Solution {
public:
    long long minOperations(vector<int>& nums1, vector<int>& nums2, int k) {
        
        long long sum1 = accumulate(nums1.begin(), nums1.end(), 0LL);
        long long sum2 = accumulate(nums2.begin(), nums2.end(), 0LL);
        long long diff = sum1 - sum2;
        if (diff < 0) {
            swap(nums1, nums2);
            diff = -diff;
        }
        if (diff > k * 5LL) {
            return -1;
        }

        vector<int> v1, v2;
        for (int x : nums1) {
            v1.push_back(x - 1);
        }
        for (int x : nums2) {
            v2.push_back(6 - x);
        }
        sort(v1.begin(), v1.end());
        sort(v2.begin(), v2.end());
        reverse(v1.begin(), v1.end());
        reverse(v2.begin(), v2.end());

        int n = nums1.size();
        int best = INT_MAX;
        for (int i = 0; i <= k; ++i) {
            int j = k - i;
            if (i > n || j > n) {
                continue;
            }
            long long cur = 0;
            for (int x = 0; x < i; ++x) {
                cur += v1[x];
            }
            for (int x = 0; x < j; ++x) {
                cur += v2[x];
            }
            if (cur >= diff) {
                best = min(best, i + j);
            }
        }
        return best;
    }
};