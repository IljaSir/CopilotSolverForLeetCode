class Solution {
public:
    int maxSumTwoNoOverlap(vector<int>& nums, int firstLen, int secondLen) {
        
        int n = nums.size();
        vector<int> prefix(n + 1);
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = nums[i] + prefix[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i + firstLen > n) break;
            int first = prefix[i + firstLen] - prefix[i];
            for (int j = 0; j < n; ++j) {
                if (j + secondLen > n) break;
                if (i < j && i + firstLen > j) continue;
                if (j < i && j + secondLen > i) continue;
                int second = prefix[j + secondLen] - prefix[j];
                ans = max(ans, first + second);
            }
        }
        return ans;
    }
};