class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sum %= p;
        }
        if (sum == 0) return 0;
        int res = n;
        int cur = 0;
        unordered_map<int, int> map;
        map[0] = -1;
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            cur %= p;
            map[cur] = i;
            int target = (cur - sum + p) % p;
            if (map.find(target) != map.end()) {
                res = min(res, i - map[target]);
            }
        }
        return res < n ? res : -1;
    }
};