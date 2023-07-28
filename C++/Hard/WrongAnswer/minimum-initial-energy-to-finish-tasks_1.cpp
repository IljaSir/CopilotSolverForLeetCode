class Solution {
public:
    int minimumEffort(vector<vector<int>>& tasks) {
        
        sort(tasks.begin(), tasks.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] - a[0] > b[1] - b[0];
        });
        int energy = 0;
        for (auto& task : tasks) {
            energy = max(energy + task[0], task[1]);
        }
        return energy;
    }
};