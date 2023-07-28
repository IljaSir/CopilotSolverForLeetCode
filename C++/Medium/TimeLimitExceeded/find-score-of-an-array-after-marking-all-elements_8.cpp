class Solution {
public:
    long long findScore(vector<int>& nums) {
        
        long long score = 0;
        int n = nums.size();
        vector<bool> marked(n);
        while (true) {
            int minVal = INT_MAX;
            int minIndex = -1;
            for (int i = 0; i < n; ++i) {
                if (marked[i]) continue;
                if (nums[i] < minVal) {
                    minVal = nums[i];
                    minIndex = i;
                }
            }
            if (minIndex == -1) break;
            score += minVal;
            marked[minIndex] = true;
            if (minIndex > 0) marked[minIndex - 1] = true;
            if (minIndex < n - 1) marked[minIndex + 1] = true;
        }
        return score;
    }
};