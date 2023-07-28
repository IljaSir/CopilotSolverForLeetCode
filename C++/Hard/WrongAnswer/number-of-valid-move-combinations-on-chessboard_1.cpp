class Solution {
public:
    int countCombinations(vector<string>& pieces, vector<vector<int>>& positions) {
        
        int n = pieces.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (pieces[i] == "rook") {
                ans += 15;
            } else if (pieces[i] == "queen") {
                ans += 22;
            } else {
                ans += 12;
            }
        }
        return ans;
    }
};