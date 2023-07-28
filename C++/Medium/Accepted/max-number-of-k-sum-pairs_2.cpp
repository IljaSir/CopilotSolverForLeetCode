class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        
        int res = 0;
        unordered_map<int, int> m;
        for (auto n : nums) {
            if (m.find(k - n) != m.end() && m[k - n] > 0) {
                res++;
                m[k - n]--;
            } else {
                m[n]++;
            }
        }
        return res;
    }
};