class Solution {
public:
    bool findSubarrays(vector<int>& nums) {
        
        int len = nums.size();
        if (len < 2) return false;
        unordered_map<int, int> sumIndex;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (sumIndex.find(sum) != sumIndex.end()) {
                if (i - sumIndex[sum] >= 2) return true;
            } else {
                sumIndex[sum] = i;
            }
        }
        return false;
    }
};