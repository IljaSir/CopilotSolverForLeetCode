class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        
        unordered_map<int, int> m;
        int ans = 0;
        for (auto &n : nums) {
            if (m[k - n] > 0) {
                m[k - n]--;
                ans++;
            } else {
                m[n]++;
            }
        }
        return ans;
    }
};