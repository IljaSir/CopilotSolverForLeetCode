class Solution {
public:
    bool findSubarrays(vector<int>& nums) {
        
        unordered_set<int> sumSet;
        int sum = 0;
        for(int i = 0; i < nums.size() - 1; i++) {
            sum += nums[i];
            if(sumSet.find(sum) != sumSet.end()) return true;
            sumSet.insert(sum);
        }
        return false;
    }
};