class Solution {
public:
    int findLucky(vector<int>& arr) {
        
        unordered_map<int, int> m;
        for (int i : arr) {
            m[i]++;
        }
        int ans = -1;
        for (auto& [k, v] : m) {
            if (k == v) {
                ans = max(ans, k);
            }
        }
        return ans;
    }
};