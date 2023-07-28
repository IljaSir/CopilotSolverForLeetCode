class Solution {
public:
    int minOperations(vector<int>& nums1, vector<int>& nums2) {
        
        int sum1 = 0;
        int sum2 = 0;
        int n1 = nums1.size();
        int n2 = nums2.size();
        for (int i = 0; i < n1; i++) {
            sum1 += nums1[i];
        }
        for (int i = 0; i < n2; i++) {
            sum2 += nums2[i];
        }
        if (sum1 == sum2) {
            return 0;
        }
        if (n1 > n2) {
            return minOperations(nums2, nums1);
        }
        vector<int> count1(7, 0);
        vector<int> count2(7, 0);
        for (int i = 0; i < n1; i++) {
            count1[nums1[i]]++;
        }
        for (int i = 0; i < n2; i++) {
            count2[nums2[i]]++;
        }
        int res = 0;
        if (sum1 < sum2) {
            int diff = sum2 - sum1;
            for (int i = 1; i <= 6; i++) {
                if (diff == 0) break;
                if (i <= 5) {
                    int num = min(count2[i + 1], diff / (i + 1));
                    res += num;
                    diff -= num * (i + 1);
                }
                int num = min(count1[i], diff / (6 - i + 1));
                res += num;
                diff -= num * (6 - i + 1);
            }
        } else {
            int diff = sum1 - sum2;
            for (int i = 6; i >= 1; i--) {
                if (diff == 0) break;
                if (i >= 2) {
                    int num = min(count1[i - 1], diff / (6 - i + 1));
                    res += num;
                    diff -= num * (6 - i + 1);
                }
                int num = min(count2[i], diff / i);
                res += num;
                diff -= num * i;
            }
        }
        return res;
    }
};