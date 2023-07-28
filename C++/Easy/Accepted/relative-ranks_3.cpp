class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        
        vector<int> sortedScore(score);
        sort(sortedScore.begin(), sortedScore.end(), greater<int>());
        unordered_map<int, int> scoreToRank;
        for (int i = 0; i < sortedScore.size(); i++) {
            scoreToRank[sortedScore[i]] = i;
        }
        vector<string> result;
        for (int i = 0; i < score.size(); i++) {
            int rank = scoreToRank[score[i]];
            if (rank == 0) {
                result.push_back("Gold Medal");
            } else if (rank == 1) {
                result.push_back("Silver Medal");
            } else if (rank == 2) {
                result.push_back("Bronze Medal");
            } else {
                result.push_back(to_string(rank + 1));
            }
        }
        return result;
    }
};