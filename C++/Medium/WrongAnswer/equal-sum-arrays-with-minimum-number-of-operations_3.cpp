class Solution {
public:
    int minOperations(vector<int>& nums1, vector<int>& nums2) {
        
        if (nums1.size() * 6 < nums2.size() || nums2.size() * 6 < nums1.size()) {
            return -1;
        }
        int sum1 = 0;
        int sum2 = 0;
        int count1[6] = {0};
        int count2[6] = {0};
        for (int i = 0; i < nums1.size(); i++) {
            sum1 += nums1[i];
            count1[nums1[i] - 1]++;
        }
        for (int i = 0; i < nums2.size(); i++) {
            sum2 += nums2[i];
            count2[nums2[i] - 1]++;
        }
        int ans = 0;
        if (sum1 < sum2) {
            for (int i = 0; i < 5; i++) {
                int diff = min(count2[5 - i - 1], (sum2 - sum1) / (5 - i));
                ans += diff;
                sum2 -= diff * (5 - i);
            }
        } else {
            for (int i = 0; i < 5; i++) {
                int diff = min(count1[5 - i - 1], (sum1 - sum2) / (5 - i));
                ans += diff;
                sum1 -= diff * (5 - i);
            }
        }
        return ans;
    }
};