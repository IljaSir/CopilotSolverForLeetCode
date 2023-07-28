class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        
        int ret = 0;
        unordered_map<int, int> m;
        for (auto i : nums) {
            if (m[k - i] > 0) {
                m[k - i]--;
                ret++;
            } else {
                m[i]++;
            }
        }
        return ret;
    }
};