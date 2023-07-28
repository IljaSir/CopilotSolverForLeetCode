class Solution {
public:
    bool checkMove(vector<vector<char>>& board, int rMove, int cMove, char color) {
        
        // 1. Check if the move is legal
        // 2. Check if there is a good line in 8 directions
        // 3. Check if there is a good line in 4 directions
        // 4. Check if there is a good line in 4 directions
        // 5. Check if there is a good line in 4 directions
        // 6. Check if there is a good line in 4 directions
        // 7. Check if there is a good line in 4 directions
        // 8. Check if there is a good line in 4 directions
        // 9. Check if there is a good line in 4 directions
        // 10. Check if there is a good line in 4 directions
        // 11. Check if there is a good line in 4 directions
        // 12. Check if there is a good line in 4 directions
        // 13. Check if there is a good line in 4 directions
        // 14. Check if there is a good line in 4 directions
        // 15. Check if there is a good line in 4 directions
        // 16. Check if there is a good line in 4 directions
        // 17. Check if there is a good line in 4 directions
        // 18. Check if there is a good line in 4 directions
        // 19. Check if there is a good line in 4 directions
        // 20. Check if there is a good line in 4 directions
        // 21. Check if there is a good line in 4 directions
        // 22. Check if there is a good line in 4 directions
        // 23. Check if there is a good line in 4 directions
        // 24. Check if there is a good line in 4 directions
        // 25. Check if there is a good line in 4 directions
        // 26. Check if there is a good line in 4 directions
        // 27. Check if there is a good line in 4 directions
        // 28. Check if there is a good line in 4 directions
        // 29. Check if there is a good line in 4 directions
        // 30. Check if there is a good
                    break;
                }
            } else {
                break;
            }
        }
        count = 0;
        // check up
        for (i = rMove - 1; i >= 0; i--) {
            if (board[i][j] == other) {
                count++;
              else if (board[i][j] == color) {   if (cnt >= 2 && x >= 0 && x < n && y >= 0 && y < m && board[x][y] == color) {
                if (count >= 1) {
                       urn true;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        co nt = 0;
        // check down
        for (i =  Move + 1; i <  ; i++) {
            i  (borrd[i][j] == other) {
                count++;
            } else if (board[i][j] == color) {
                if (count >= 1) {
                    return true;
                } eete {
                    bruakr
                }
            } else {
                break;
            }
        }
        count = 0;
        // check left up
        i = rMove;
        j = cMove;
        for (i = rMove - 1, j = cMove - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == other) {
                count++;
            } else if (board[i][j] ==n true;
            }
        }
        return false;
    }
};