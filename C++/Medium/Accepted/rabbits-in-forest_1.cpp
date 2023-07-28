class Solution {
public:
    int numRabbits(vector<int>& answers) {
        
        unordered_map<int, int> count;
        for (int ans : answers) {
            ++count[ans];
        }
        int ans = 0;
        for (auto [x, y] : count) {
            ans += (y + x) / (x + 1) * (x + 1);
        }
        return ans;
    }
};