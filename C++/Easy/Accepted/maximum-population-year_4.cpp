class Solution {
public:
    int maximumPopulation(vector<vector<int>>& logs) {
        
        int n = logs.size();
        vector<int> year(101, 0);
        for (int i = 0; i < n; i++) {
            for (int j = logs[i][0] - 1950; j < logs[i][1] - 1950; j++) {
                year[j]++;
            }
        }
        int maxYear = 0;
        int maxPop = 0;
        for (int i = 0; i < 101; i++) {
            if (year[i] > maxPop) {
                maxPop = year[i];
                maxYear = i;
            }
        }
        return maxYear + 1950;
    }
};