class Solution {
public:
    int hardestWorker(int n, vector<vector<int>>& logs) {
        
        vector<int> times(n, 0);
        for (auto& log : logs) {
            times[log[0]] += log[1] - (log == logs.front() ? 0 : logs[&log - &logs.front() - 1][1]);
        }
        return max_element(times.begin(), times.end()) - times.begin();
    }
};