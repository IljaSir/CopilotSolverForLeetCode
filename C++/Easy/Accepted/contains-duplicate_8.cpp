class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        
        std::sort(nums.begin(), nums.end());
        return std::adjacent_find(nums.begin(), nums.end()) != nums.end();
    }
};