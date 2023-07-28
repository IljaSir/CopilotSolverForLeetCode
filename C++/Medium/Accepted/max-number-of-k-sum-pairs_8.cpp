class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        
        int result = 0;
        unordered_map<int, int> m;
        for (auto n : nums) {
            if (m.count(k - n) && m[k - n] > 0) {
                m[k - n]--;
                result++;
            } else {
                m[n]++;
            }
        }
        return result;
    }
};