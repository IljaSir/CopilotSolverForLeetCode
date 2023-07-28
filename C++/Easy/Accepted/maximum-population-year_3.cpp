class Solution {
public:
    int maximumPopulation(vector<vector<int>>& logs) {
        
        int n = logs.size();
        vector<int> v(2051, 0);
        for (int i = 0; i < n; i++) {
            for (int j = logs[i][0]; j < logs[i][1]; j++) {
                v[j]++;
            }
        }
        int max = 0;
        int ans = 0;
        for (int i = 0; i < 2051; i++) {
            if (v[i] > max) {
                max = v[i];
                ans = i;
            }
        }
        return ans;
    }
};