class Solution {
public:
    int numRabbits(vector<int>& answers) {
        
        int result = 0;
        unordered_map<int, int> m;
        for (auto& a : answers) {
            if (m.find(a) == m.end()) {
                m[a] = a;
                result += a + 1;
            } else {
                if (m[a] == 0) {
                    m[a] = a;
                    result += a + 1;
                } else {
                    m[a]--;
                }
            }
        }
        return result;
    }
};