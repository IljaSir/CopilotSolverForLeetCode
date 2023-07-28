class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        
        int res = 0;
        unordered_map<int, int> m;
        for (int i = 0; i < nums.size(); i++) {
            if (m.find(k - nums[i]) != m.end() && m[k - nums[i]] > 0) {
                m[k - nums[i]]--;
                res++;
            } else {
                m[nums[i]]++;
            }
        }
        return res;
    }
};