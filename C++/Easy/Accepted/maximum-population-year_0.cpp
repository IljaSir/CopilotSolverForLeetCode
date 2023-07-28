class Solution {
public:
    int maximumPopulation(vector<vector<int>>& logs) {
        
        vector<int> count(101, 0);
        for (auto& log : logs) {
            for (int i = log[0] - 1950; i < log[1] - 1950; ++i) {
                count[i]++;
            }
        }
        int max = 0;
        int year = 0;
        for (int i = 0; i < 101; ++i) {
            if (count[i] > max) {
                max = count[i];
                year = i;
            }
        }
        return 1950 + year;
    }
};