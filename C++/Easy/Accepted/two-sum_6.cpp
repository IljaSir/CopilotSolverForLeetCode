class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        map<int, int> cache;
        for(int i = 0; i < nums.size(); i++) {
            if(cache.find(target - nums[i]) != cache.end()) {
                return {cache[target - nums[i]], i};
            }
            cache[nums[i]] = i;
        }
        return {};
    }
};