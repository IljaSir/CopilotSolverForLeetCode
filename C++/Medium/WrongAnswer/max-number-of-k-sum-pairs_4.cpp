class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        
        unordered_map<int, int> m;
        int cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (m.count(k - nums[i])) {
                if (m[k - nums[i]] > 0) {
                    m[k - nums[i]]--;
                    cnt++;
                }
            } else {
                m[nums[i]]++;
            }
        }
        return cnt;
    }
};