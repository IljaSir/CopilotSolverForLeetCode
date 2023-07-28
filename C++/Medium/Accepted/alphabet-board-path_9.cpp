class Solution {
public:
    string alphabetBoardPath(string target) {
        
        int row = 0;
        int col = 0;
        string path = "";
        for (int i = 0; i < target.size(); i++) {
            int targetRow = (target[i] - 'a') / 5;
            int targetCol = (target[i] - 'a') % 5;
            while (row > targetRow) {
                path += 'U';
                row--;
            }
            while (col < targetCol) {
                path += 'R';
                col++;
            }
            while (col > targetCol) {
                path += 'L';
                col--;
            }
            while (row < targetRow) {
                path += 'D';
                row++;
            }
            path += '!';
        }
        return path;
    }
};