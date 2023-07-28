class Solution {
public:
    int maximumPopulation(vector<vector<int>>& logs) {
        
        int minYear = INT_MAX;
        int maxYear = INT_MIN;
        for (auto log : logs) {
            minYear = min(minYear, log[0]);
            maxYear = max(maxYear, log[1]);
        }
        vector<int> years(maxYear - minYear + 1, 0);
        for (auto log : logs) {
            for (int i = log[0]; i < log[1]; i++) {
                years[i - minYear]++;
            }
        }
        int maxPopulation = INT_MIN;
        int maxPopulationYear = INT_MIN;
        for (int i = 0; i < years.size(); i++) {
            if (years[i] > maxPopulation) {
                maxPopulation = years[i];
                maxPopulationYear = i + minYear;
            }
        }
        return maxPopulationYear;
    }
};