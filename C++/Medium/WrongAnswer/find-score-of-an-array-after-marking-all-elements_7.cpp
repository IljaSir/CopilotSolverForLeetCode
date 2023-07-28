class Solution {
public:
    long long findScore(vector<int>& nums) {
        
        long long score = 0;
        int n = nums.size();
        vector<int> mark(n, 0);
        int i = 0;
        while(i < n) {
            int j = i;
            while(j < n && nums[j] == nums[i]) {
                j++;
            }
            int x = i + 1;
            while(x < n && mark[x] == 1) {
                x++;
            }
            if(x < n) {
                score += nums[i];
                mark[x] = 1;
                if(x > 0) {
                    mark[x - 1] = 1;
                }
                if(x < n - 1) {
                    mark[x + 1] = 1;
                }
            }
            i = j;
        }
        return score;
    }
};