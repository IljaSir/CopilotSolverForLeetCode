class Solution {
public:
    long long numberOfPairs(vector<int>& nums1, vector<int>& nums2, int diff) {
        
        int n = nums1.size();
        vector<int> cnt(20001, 0);
        for (int i = 0; i < n; i++) {
            cnt[nums1[i] - nums2[i] + 10000]++;
        }
        long long res = 0;
        for (int i = 0; i < n; i++) {
            res += cnt[nums1[i] - nums2[i] - diff + 10000];
        }
        return res;
    }
};