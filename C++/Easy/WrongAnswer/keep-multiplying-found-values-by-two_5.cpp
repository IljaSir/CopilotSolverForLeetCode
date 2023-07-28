class Solution {
public:
    int findFinalValue(vector<int>& nums, int original) {
        
        for (auto x : nums)
            if (x == original)
                original *= 2;
        return original;
    }
};