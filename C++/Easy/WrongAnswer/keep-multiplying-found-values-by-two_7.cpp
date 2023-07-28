class Solution {
public:
    int findFinalValue(vector<int>& nums, int original) {
        
        for(auto i: nums) {
            if(original == i) {
                original *= 2;
            }
        }
        return original;
    }
};