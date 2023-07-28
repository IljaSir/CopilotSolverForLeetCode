class Solution {
public:
    int minOperations(vector<int>& nums1, vector<int>& nums2) {
        
        int n1 = nums1.size();
        int n2 = nums2.size();
        if (n1 > n2 * 6 || n2 > n1 * 6) return -1;
        int sum1 = accumulate(nums1.begin(), nums1.end(), 0);
        int sum2 = accumulate(nums2.begin(), nums2.end(), 0);
        if (sum1 > sum2) return minOperations(nums2, nums1);
        int diff = sum2 - sum1;
        vector<int> count1(6, 0), count2(6, 0);
        for (int i = 0; i < n1; ++i) ++count1[nums1[i] - 1];
        for (int i = 0; i < n2; ++i) ++count2[nums2[i] - 1];
        int ans = 0;
        for (int i = 5; i >= 0 && diff > 0; --i) {
            int x = min(diff / (i + 1), count1[i]);
            ans += x;
            diff -= x * (i + 1);
            x = min(diff / (6 - i), count2[5 - i]);
            ans += x;
            diff -= x * (6 - i);
        }
        return ans;
    }
};