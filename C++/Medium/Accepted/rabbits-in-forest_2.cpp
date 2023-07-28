class Solution {
public:
    int numRabbits(vector<int>& answers) {
        
        int n = answers.size();
        int res = 0;
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            m[answers[i]]++;
        }
        for (auto it = m.begin(); it != m.end(); it++) {
            int x = it->first;
            int y = it->second;
            res += (y + x) / (x + 1) * (x + 1);
        }
        return res;
    }
};