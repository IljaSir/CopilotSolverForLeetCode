class Solution {
public:
    long long minimumTotalCost(vector<int>& nums1, vector<int>& nums2) {
        
        vector<int> cnt1(100001, 0), cnt2(100001, 0);
        int n = nums1.size();
        for (int i = 0; i < n; i++) {
            if (nums1[i] != nums2[i]) {
                cnt1[nums1[i]]++;
                cnt2[nums2[i]]++;
            }
        }
        long long res = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt1[i] == 0 && cnt2[i] == 0) continue;
            if (cnt1[i] > 0 && cnt2[i] > 0) {
                res += min(cnt1[i], cnt2[i]);
                cnt1[i] -= min(cnt1[i], cnt2[i]);
                cnt2[i] -= min(cnt1[i], cnt2[i]);
            }
            res += (cnt1[i] + cnt2[i]);
        }
        return res;
    }
};