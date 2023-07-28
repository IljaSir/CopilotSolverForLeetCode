class Solution {
public:
    long long findScore(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> mark(n, 0);
        long long score = 0;
        while (true) {
            int min = INT_MAX;
            int minIndex = -1;
            for (int i = 0; i < n; i++) {
                if (mark[i] == 0 && nums[i] < min) {
                    min = nums[i];
                    minIndex = i;
                }
            }
            if (minIndex == -1) {
                break;
            }
            score += nums[minIndex];
            mark[minIndex] = 1;
            if (minIndex - 1 >= 0) {
                mark[minIndex - 1] = 1;
            }
            if (minIndex + 1 < n) {
                mark[minIndex + 1] = 1;
            }
        }
        return score;
    }
};