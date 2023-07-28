class Solution {
public:
    int maximumPopulation(vector<vector<int>>& logs) {
        
        int max_population = 0;
        int max_year = 0;
        for (int year = 1950; year <= 2050; year++) {
            int population = 0;
            for (const auto& log : logs) {
                if (year >= log[0] && year < log[1]) {
                    population++;
                }
            }
            if (population > max_population) {
                max_population = population;
                max_year = year;
            }
        }
        return max_year;
    }
};