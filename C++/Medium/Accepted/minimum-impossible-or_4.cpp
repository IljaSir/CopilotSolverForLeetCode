class Solution {
public:
    int minImpossibleOR(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int cur = 0;
        for (auto& x : nums) {
            if (x <= cur + 1) cur |= x;
            else break;
        }
        return cur + 1;
    }
};