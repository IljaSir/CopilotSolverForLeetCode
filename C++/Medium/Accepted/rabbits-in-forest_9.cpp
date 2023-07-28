class Solution {
public:
    int numRabbits(vector<int>& answers) {
        
        if (answers.empty()) return 0;
        int res = 0;
        unordered_map<int, int> m;
        for (auto& answer : answers) {
            if (m[answer] == 0) {
                res += answer + 1;
            }
            m[answer] = (m[answer] + 1) % (answer + 1);
        }
        return res;
    }
};