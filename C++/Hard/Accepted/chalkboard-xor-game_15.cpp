class Solution {
public:
    bool xorGame(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        for(auto& num: nums){
            res ^= num;
        }
        return res == 0 || n % 2 == 0;
    }
};