class Solution {
public:
    int numRabbits(vector<int>& answers) {
        
        unordered_map<int, int> m;
        for (auto a : answers) {
            m[a]++;
        }
        int res = 0;
        for (auto it = m.begin(); it != m.end(); it++) {
            int count = it->second;
            int color = it->first;
            while (count > 0) {
                res += (color + 1);
                count -= (color + 1);
            }
        }
        return res;
    }
};