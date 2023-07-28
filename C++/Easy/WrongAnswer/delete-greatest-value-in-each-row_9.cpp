class Solution {
public:
    int deleteGreatestValue(vector<vector<int>>& grid) {
        
        int res = 0;
        while(!grid.empty()) {
            int max = 0;
            int index = 0;
            for(int i = 0; i < grid.size(); i++) {
                int temp = *max_element(grid[i].begin(), grid[i].end());
                if(temp > max) {
                    max = temp;
                    index = i;
                }
            }
            res += max;
            grid[index].erase(max_element(grid[index].begin(), grid[index].end()));
            if(grid[index].empty()) {
                grid.erase(grid.begin() + index);
            }
        }
        return res;
    }
};