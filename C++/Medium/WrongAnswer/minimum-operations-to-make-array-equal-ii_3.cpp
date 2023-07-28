class Solution {
public:
    long long minOperations(vector<int>& nums1, vector<int>& nums2, int k) {
        
        int n = nums1.size();
        vector<int> diff;
        for (int i = 0; i < n; i++) {
            diff.push_back(nums1[i] - nums2[i]);
        }
        sort(diff.begin(), diff.end());
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += diff[i];
        }
        if (sum > 0) return 0;
        int ans = k;
        for (int i = k; i < n; i++) {
            sum += diff[i];
            if (sum > 0) break;
            ans++;
        }
        return ans;
    }
};