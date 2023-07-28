class Solution {
public:
    int findLucky(vector<int>& arr) {
        
        unordered_map<int, int> m;
        for (auto a : arr) {
            m[a]++;
        }
        int ans = -1;
        for (auto [a, b] : m) {
            if (a == b) {
                ans = max(ans, a);
            }
        }
        return ans;
    }
};