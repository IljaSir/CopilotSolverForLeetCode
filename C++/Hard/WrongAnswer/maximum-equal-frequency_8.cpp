class Solution {
public:
    int maxEqualFreq(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        int j = 0;
        int ans = 0;
        unordered_map<int, int> m;
        unordered_map<int, int> freq;
        int maxFreq = 0;
        while (j < n) {
            m[nums[j]]++;
            freq[m[nums[j]]]++;
            maxFreq = max(maxFreq, m[nums[j]]);
            if (freq[maxFreq] * maxFreq == j - i + 1) {
                ans = max(ans, j - i + 1);
            } else if (freq[maxFreq] * maxFreq == j - i) {
                ans = max(ans, j - i);
            } else if (freq[maxFreq] * maxFreq == j - i - 1) {
                ans = max(ans, j - i - 1);
            } else if (freq[maxFreq] * maxFreq == j - i - 2) {
                ans = max(ans, j - i - 2);
            }
            j++;
        }
        return ans;
    }
};