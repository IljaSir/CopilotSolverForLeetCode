class Solution {
public:
    bool canIWin(int maxChoosableInteger, int desiredTotal) {
        
        if (desiredTotal <= 0) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        vector<bool> visited(maxChoosableInteger + 1, false);
        return canWin(maxChoosableInteger, desiredTotal, visited);
    }
    
    bool canWin(int maxChoosableInteger, int desiredTotal, vector<bool>& visited) {
        if (desiredTotal <= 0) return false;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (!canWin(maxChoosableInteger, desiredTotal - i, visited)) {
                    visited[i] = false;
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
};