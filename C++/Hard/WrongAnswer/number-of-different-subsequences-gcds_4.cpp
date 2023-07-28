class Solution {
public:
    int countDifferentSubsequenceGCDs(vector<int>& nums) {
        
        int n = nums.size();
        int maxNum = *max_element(nums.begin(), nums.end());
        vector<int> freq(maxNum + 1, 0);
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        int ans = 0;
        for (int i = 1; i <= maxNum; i++) {
            if (freq[i] == 0) {
                continue;
            }
            ans++;
            for (int j = i + i; j <= maxNum; j += i) {
                if (freq[j] > 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
};