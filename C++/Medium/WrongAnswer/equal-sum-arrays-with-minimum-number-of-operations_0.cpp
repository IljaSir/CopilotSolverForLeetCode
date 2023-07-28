class Solution {
public:
    int minOperations(vector<int>& nums1, vector<int>& nums2) {
        
        int sum1 = accumulate(nums1.begin(), nums1.end(), 0);
        int sum2 = accumulate(nums2.begin(), nums2.end(), 0);
        if (sum1 == sum2) return 0;
        if (sum1 > sum2) {
            swap(sum1, sum2);
            swap(nums1, nums2);
        }
        int diff = sum2 - sum1;
        int n1 = nums1.size(), n2 = nums2.size();
        if (n1 * 6 < diff || n2 * 1 > diff) return -1;
        vector<int> freq1(7), freq2(7);
        for (int x : nums1) freq1[x]++;
        for (int x : nums2) freq2[x]++;
        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            int need = (i - 1) * freq1[i];
            if (diff <= need) {
                ans += (diff + i - 2) / (i - 1);
                break;
            }
            ans += freq1[i];
            diff -= need;
        }
        for (int i = 6; i >= 1; i--) {
            int need = (7 - i) * freq2[i];
            if (diff <= need) {
                ans += (diff + 7 - i - 1) / (7 - i);
                break;
            }
            ans += freq2[i];
            diff -= need;
        }
        return ans;
    }
};