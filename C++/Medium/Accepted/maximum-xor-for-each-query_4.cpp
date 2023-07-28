class Solution {
public:
    vector<int> getMaximumXor(vector<int>& nums, int maximumBit) {
        
        int n = nums.size();
        vector<int> answer(n);
        int x = 0;
        for (int i = 0; i < n; ++i) {
            x ^= nums[i];
        }
        for (int i = 0; i < n; ++i) {
            answer[i] = (1 << maximumBit) - 1 - x;
            x ^= nums[n - 1 - i];
        }
        return answer;
    }
};