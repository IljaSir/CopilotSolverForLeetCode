class Solution {
public:
    int numRabbits(vector<int>& answers) {
        
        int n = answers.size();
        if (n == 0) return 0;
        int res = 0;
        unordered_map<int, int> m;
        for (int i = 0; i < n; ++i) {
            if (m[answers[i]] > 0) {
                --m[answers[i]];
            } else {
                res += answers[i] + 1;
                m[answers[i]] = answers[i];
            }
        }
        return res;
    }
};