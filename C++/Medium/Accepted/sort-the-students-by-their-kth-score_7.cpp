class Solution {
public:
    vector<vector<int>> sortTheStudents(vector<vector<int>>& score, int k) {
        
        // 1. sort the scores
        std::sort(score.begin(), score.end(), [k](auto& a, auto& b){
            return a[k] > b[k];
        });
        return score;
    }
};