class Solution {
public:
    int numTriplets(vector<int>& nums1, vector<int>& nums2) {
        
        return solve(nums1, nums2) + solve(nums2, nums1);
    }
    
    int solve(vector<int>& nums1, vector<int>& nums2) {
        int ans = 0;
        unordered_map<long long, int> mp;
        for (auto& x: nums2) {
            mp[x * x]++;
        }
        for (int i = 0; i < nums1.size(); ++i) {
            for (int j = i + 1; j < nums1.size(); ++j) {
                ans += mp[nums1[i] * 1ll * nums1[j]];
            }
        }
        return ans;
    }
};