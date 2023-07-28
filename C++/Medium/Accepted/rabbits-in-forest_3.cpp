class Solution {
public:
    int numRabbits(vector<int>& answers) {
        
        int n = answers.size();
        if (n == 0) return 0;
        if (n == 1) return answers[0] + 1;
        unordered_map<int, int> m;
        for (int i = 0; i < n; ++i) {
            ++m[answers[i]];
        }
        int ans = 0;
        for (auto& p : m) {
            int x = p.first;
            int y = p.second;
            ans += (y + x) / (x + 1) * (x + 1);
        }
        return ans;
    }
};