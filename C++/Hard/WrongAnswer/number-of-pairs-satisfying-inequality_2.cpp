class Solution {
public:
    long long numberOfPairs(vector<int>& nums1, vector<int>& nums2, int diff) {
        
        int n = nums1.size();
        vector<int> v(n);
        for (int i = 0; i < n; ++i) {
            v[i] = nums1[i] - nums2[i];
        }
        sort(v.begin(), v.end());
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            int j = upper_bound(v.begin(), v.end(), v[i] - diff) - v.begin();
            ans += i - j;
        }
        return ans;
    }
};