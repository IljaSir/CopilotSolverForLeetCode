class Solution {
public:
    bool hasValidPath(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dir = {{0,1},{0,-1},{1,0},{-1,0}};
        vector<vector<int>> dir2 = {{-1,0},{1,0},{0,1},{0,-1}};
        vector<vector<int>> dir3 = {{-1,0},{0,1},{1,0},{0,-1}};
        vector<vector<int>> dir4 = {{0,1},{1,0},{0,-1},{-1,0}};
        vector<vector<int>> dir5 = {{-1,0},{0,1},{0,-1}};
        vector<vector<int>> dir6 = {{0,1},{1,0},{0,-1}};
        vector<vector<int>> dir7 = {{-1,0},{0,1},{-1,0}};
        vector<vector<int>> dir8 = {{0,1},{1,0},{0,-1}};
        vector<vector<int>> dir9 = {{-1,0},{0,1},{0,-1}};
        vector<vector<int>> dir10 = {{-1,0},{1,0},{0,-1}};
        vector<vector<int>> dir11 = {{-1,0},{1,0},{0,1}};
        vector<vector<int>> dir12 = {{0,1},{1,0},{-1,0}};
        vector<vector<int>> dir13 = {{0,1},{0,-1},{-1,0}};
        vector<vector<int>> dir14 = {{0,1},{0,-1},{1,0}};
        vector<vector<int>> dir15 = {{1,0},{0,-1},{-1,0}};
        vector<vector<int>> dir16 = {{1,0},{0,1},{-1,0}};
        vector<vector<int>> dir17 = {{1,0},{0,1},{0,-1}};
        vector<vector<int>> dir18 = {{-1,0},{0,1},{1,0}};
        vector<vector<int>> dir19 = {{0,1},{-1,0},{1,0}};
        vector<vector<int>> dir20 = {{0,-1},{-1,0},{1,0}};
        vector<vector<int>> dir21 = {{0,1},{0,-1},{-1,0},{1,0}};
        vector<vector<int>> dir
    }
};