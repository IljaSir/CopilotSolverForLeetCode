class Solution {
public:
    bool canFormArray(vector<int>& arr, vector<vector<int>>& pieces) {
        
        unordered_map<int, vector<int>> pieceMap;
        for (auto& piece : pieces) {
            pieceMap[piece[0]] = piece;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (pieceMap.count(arr[i])) {
                auto piece = pieceMap[arr[i]];
                for (int j = 0; j < piece.size(); j++) {
                    if (arr[i + j] != piece[j]) {
                        return false;
                    }
                }
                i += piece.size() - 1;
            } else {
                return false;
            }
        }
        return true;
    }
};