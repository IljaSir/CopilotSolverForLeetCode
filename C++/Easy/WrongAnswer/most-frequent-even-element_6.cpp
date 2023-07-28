class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        
        int n = nums.size();
        int maxCount = 0, maxElement = -1;
        unordered_map<int, int> mp;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                mp[nums[i]]++;
                if (mp[nums[i]] > maxCount) {
                    maxCount = mp[nums[i]];
                    maxElement = nums[i];
                }
            }
        }
        return maxElement;
    }
};