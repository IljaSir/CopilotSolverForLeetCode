class Solution {
public:
    int findLucky(vector<int>& arr) {
        
        int ans = -1;
        map<int, int> m;
        for (auto &x: arr) {
            m[x]++;
        }
        for (auto &x: m) {
            if (x.first == x.second) {
                ans = x.first;
            }
        }
        return ans;
    }
};