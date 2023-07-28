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
        int m = target.size();
        int mid = (n + m) / 2;
        vector<int> nums1, nums2, target1, target2;
        for (int i = 0; i < mid; i++) {
            nums1.push_back(nums[i]);
            target1.push_back(target[i]);
        }
        for (int i = mid; i < n; i++) {
            nums2.push_back(nums[i]);
            target2.push_back(target[i]);
        }
        unordered_map<long long, int> m1, m2;
        int len1 = nums1.size();
        int len2 = nums2.size();
        for (int i = 0; i < (1 << len1); i++) {
            vector<int> tmp;
            for (int j = 0; j < len1; j++) {
                if ((i >> j) & 1) {
                    tmp.push_back(nums1[j]);
                }
            }
            m1[makeSimilar(tmp, target1)]++;
        }
        for (int i = 0; i < (1 << len2); i++) {
            vector<int> tmp;
            for (int j = 0; j < len2; j++) {
                if ((i >> j) & 1) {
                    tmp.push_back(nums2[j]);
                }
            }
            m2[makeSimilar(tmp, target2)]++;
        }
        int ans = INT_MAX;
        for (auto& [key, value] : m1) {
            if (m2.count(-key)) {
                ans = min(ans, value + m2[-key]);
            }
        }
        if (ans == INT_MAX) {
            ans = -1;
        }
        return ans;
    }
};