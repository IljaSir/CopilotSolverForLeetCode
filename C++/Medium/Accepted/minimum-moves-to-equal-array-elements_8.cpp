class Solution {
public:
    int minMoves(vector<int>& nums) {
        
        int n = nums.size();
        if(n == 1) return 0;
        int min_num = INT_MAX;
        for(int num : nums) min_num = min(min_num, num);
        int ans = 0;
        for(int num : nums) ans += (num - min_num);
        return ans;
    }
};