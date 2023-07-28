class Solution {
public:
    int numRabbits(vector<int>& answers) {
        
        map<int, int> m;
        for (auto &ans : answers) {
            m[ans]++;
        }
        int res = 0;
        for (auto &kv : m) {
            res += (kv.second + kv.first) / (kv.first + 1) * (kv.first + 1);
        }
        return res;
    }
};