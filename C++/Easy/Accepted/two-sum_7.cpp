class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        map<int, int> m;
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            int n = nums[i];
            if (m.find(n) == m.end()) {
                m[target - n] = i;
            } else {
                res.push_back(m[n]);
                res.push_back(i);
                break;
            }
        }
        return res;
    }
};