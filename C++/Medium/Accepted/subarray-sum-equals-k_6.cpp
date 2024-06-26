class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        
        unordered_map<int, int> map;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            if (sum == k) {
                count++;
            }
            if (map.find(sum - k) != map.end()) {
                count += map[sum - k];
            }
            if (map.find(sum) == map.end()) {
                map[sum] = 1;
            } else {
                map[sum]++;
            }
        }
        return count;
    }
};