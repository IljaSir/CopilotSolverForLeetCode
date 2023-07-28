class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        
        int ans = 0;
        unordered_map<int, int> m;
        for (int i : nums) {
            if (m.count(k - i) && m[k - i] > 0) {
                ans++;
                m[k - i]--;
            } else {
                m[i]++;
            }
        }
        return ans;
    }
};