class Solution {
public:
    int maxEqualFreq(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        unordered_map<int, int> count;
        unordered_map<int, int> freq;
        for (int i = 0; i < n; i++) {
            int c = ++count[nums[i]];
            freq[c]++;
            if (c * freq[c] == i + 1 && i < n - 1) {
                ans = max(ans, i + 2);
            }
            if (c * freq[c] == i && i < n - 1) {
                ans = max(ans, i + 1);
            }
            if ((c - 1) * freq[c - 1] == i - 1) {
                ans = max(ans, i);
            }
        }
        return ans;
    }
};