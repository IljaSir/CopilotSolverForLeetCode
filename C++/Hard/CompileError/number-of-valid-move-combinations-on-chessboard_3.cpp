class Solution {
public:
    int countCombinations(vector<string>& pieces, vector<vector<int>>& positions) {
        
        int res = 0;
        for (int i = 0; i < pieces.size(); ++i) {
            res += count(pieces, positions, i);
        }
        return res;
    }
    
    int count(vector<string>& pieces, vector<vector<int>>& positions, int idx) {
        int res = 0;
        for (int i = 0; i < positions.size(); ++i) {
            if (i == idx) continue;
            if (pieces[i] == "rook" && (positions[i][0] == positions[idx][0] || positions[i][1] == positions[idx][1])) {
                return 0;
            }
            if (pieces[i] == "bishop" && abs(positions[i][0] - positions[idx][0]) == abs(positions[i][1] - positions[idx][1])) {
                return 0;
            }
            if (pieces[i] == "queen" && (positions[i][0] == positions[idx][0] || positions[i][1] == positions[idx][1] || abs(positions[i][0] - positions[idx][0]) == abs(positions[i][1] - positions[idx][1]))) {
                return 0;
            }
        }
        if (pieces[idx] == "rook") {
            res = 14;
        } else if (pieces[idx] == "bishop") {
            res = 11;
        } else {
            res = 21;
        }
        for (int i = 0; i < positions.size(); ++i) {
            if (i == idx) continue;
            if (pieces[i] == "rook" && positions[i][0] == positions[idx][0]) {
                res--;
            }
            if (pieces[i] == "rook" && positions[i][1] == positions[idx][1]) {
                res--;
            }
            if (pieces[i] == "bishop" && abs(positions[i][0] - positions[idx][0]) == abs(positions[i][1] - positions[idx][1])) {
                res--;
            }
            if (pieces[i] == "queen" && positions[i][0] == positions[idx][0]) {
                res--;
            }
            if (pieces[i] == "queen" && positions[i][1] == positions[idx][1]) {
                res--;
            }
            if (pieces[i
    }
};