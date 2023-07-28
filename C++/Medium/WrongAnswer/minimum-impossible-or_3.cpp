class Solution {
public:
    int minImpossibleOR(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int cur = 1;
        for (int n : nums) {
            if (n <= cur) cur += n;
            else break;
        }
        return cur;
    }
};