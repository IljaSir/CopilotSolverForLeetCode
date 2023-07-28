class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        
        map<int, int> m;
        int n = wall.size();
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=0; j<wall[i].size()-1; j++) {
                sum += wall[i][j];
                m[sum] += 1;
            }
        }
        int max_count = 0;
        for (auto it=m.begin(); it!=m.end(); it++) {
            max_count = max(max_count, it->second);
        }
        return n - max_count;
    }
};