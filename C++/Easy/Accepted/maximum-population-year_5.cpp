class Solution {
public:
    int maximumPopulation(vector<vector<int>>& logs) {
        
        vector<int> v(102, 0);
        for (auto& log : logs) {
            v[log[0] - 1950] += 1;
            v[log[1] - 1950] -= 1;
        }
        int ans = 0;
        int max = 0;
        int total = 0;
        for (int i = 0; i < 102; i++) {
            total += v[i];
            if (total > max) {
                max = total;
                ans = i;
            }
        }
        return ans + 1950;
    }
};