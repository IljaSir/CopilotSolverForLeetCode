class Solution {
public:
    long long makeSimilar(vector<int>& nums, vector<int>& target) {
        
        long long sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i] - target[i];
        }
        return sum;
    }
    int minOperations(vector<int>& nums, vector<int>& target) {
        int n = nums.size();
        vector<int> nums1(nums.begin(), nums.begin() + n / 2);
        vector<int> nums2(nums.begin() + n / 2, nums.end());
        vector<int> target1(target.begin(), target.begin() + n / 2);
        vector<int> target2(target.begin() + n / 2, target.end());
        // make nums1 similar to target1
        // make nums2 similar to target2
        long long sum1 = makeSimilar(nums1, target1);
        long long sum2 = makeSimilar(nums2, target2);
        if (sum1 + sum2 == 0) return 0;
        if (sum1 + sum2 < 0) return -1;
        // sum1 + sum2 > 0
        unordered_map<long long, int> m;
        for (int i = 0; i < (1 << nums1.size()); i++) {
            long long sum = 0;
            for (int j = 0; j < nums1.size(); j++) {
                if (i & (1 << j)) {
                    sum += nums1[j] - target1[j];
                }
            }
            m[sum]++;
        }
        int ans = INT_MAX;
        for (int i = 0; i < (1 << nums2.size()); i++) {
            long long sum = 0;
            for (int j = 0; j < nums2.size(); j++) {
                if (i & (1 << j)) {
                    sum += nums2[j] - target2[j];
                }
            }
            if (m.count(sum1 + sum2 - sum)) {
                ans = min(ans, m[sum1 + sum2 - sum] + __builtin_popcount(i));
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};