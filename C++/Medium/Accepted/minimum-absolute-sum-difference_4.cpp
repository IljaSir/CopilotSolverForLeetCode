class Solution {
public:
    int minAbsoluteSumDiff(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        long long sum = 0;
        int maxn = 0;
        multiset<int> s(nums1.begin(), nums1.end());
        for(int i = 0; i < n; ++i) {
            int diff = abs(nums1[i] - nums2[i]);
            sum += diff;
            auto it = s.lower_bound(nums2[i]);
            if(it != s.end()) {
                maxn = max(maxn, diff - (*it - nums2[i]));
            }
            if(it != s.begin()) {
                maxn = max(maxn, diff - (nums2[i] - *prev(it)));
            }
        }
        return (sum - maxn) % (int)(1e9 + 7);
    }
};