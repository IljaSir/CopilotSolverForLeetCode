class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        
        vector<vector<int>> pascal;
        if(numRows == 0) return pascal;
        vector<int> firstRow;
        firstRow.push_back(1);
        pascal.push_back(firstRow);
        if(numRows == 1) return pascal;
        vector<int> secondRow;
        secondRow.push_back(1);
        secondRow.push_back(1);
        pascal.push_back(secondRow);
        if(numRows == 2) return pascal;
        for(int i = 2; i < numRows; i++){
            vector<int> row;
            row.push_back(1);
            for(int j = 1; j < i; j++){
                row.push_back(pascal[i-1][j-1] + pascal[i-1][j]);
            }
            row.push_back(1);
            pascal.push_back(row);
        }
        return pascal;
    }
};