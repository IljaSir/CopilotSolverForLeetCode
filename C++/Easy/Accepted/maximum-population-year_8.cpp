class Solution {
public:
    int maximumPopulation(vector<vector<int>>& logs) {
        
        sort(logs.begin(), logs.end());
        int maxPop = 0;
        int maxYear = 0;
        for (int year = 1950; year < 2050; ++year) {
            int pop = 0;
            for (int i = 0; i < logs.size(); ++i) {
                if (logs[i][0] <= year && logs[i][1] > year) {
                    ++pop;
                }
            }
            if (pop > maxPop) {
                maxPop = pop;
                maxYear = year;
            }
        }
        return maxYear;
    }
};