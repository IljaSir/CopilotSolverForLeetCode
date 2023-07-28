class Solution {
public:
    int minOperations(vector<int>& nums1, vector<int>& nums2) {
        
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums1.size(); ++i) sum1 += nums1[i];
        for (int i = 0; i < nums2.size(); ++i) sum2 += nums2[i];
        if (sum1 > sum2) return minOperations(nums2, nums1);
        vector<int> cnt1(7, 0), cnt2(7, 0);
        for (int i = 0; i < nums1.size(); ++i) ++cnt1[nums1[i]];
        for (int i = 0; i < nums2.size(); ++i) ++cnt2[nums2[i]];
        int ans = 0;
        while (sum1 < sum2) {
            int i = 1, j = 6;
            while (i <= 6 && cnt1[i] == 0) ++i;
            while (j >= 1 && cnt2[j] == 0) --j;
            if (i > 6 || j < 1) return -1;
            int d = min(sum2 - sum1, min(cnt1[i] * i, cnt2[j] * (6 - j + 1)));
            sum1 += d;
            sum2 -= d;
            cnt1[i] -= d / i;
            cnt2[j] -= d / (6 - j + 1);
            ++ans;
        }
        return ans;
    }
};