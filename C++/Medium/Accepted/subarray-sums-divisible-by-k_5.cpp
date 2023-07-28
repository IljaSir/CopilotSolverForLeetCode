class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        
        int result = 0;
        int sum = 0;
        unordered_map<int, int> map;
        map[0] = 1;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            int mod = (sum % k + k) % k;
            if (map.find(mod) != map.end()) {
                result += map[mod];
                map[mod]++;
            } else {
                map[mod] = 1;
            }
        }
        return result;
    }
};