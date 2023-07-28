class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        
        vector<string> result;
        vector<int> sortedScore = score;
        sort(sortedScore.begin(), sortedScore.end());
        for (int i = 0; i < score.size(); i++) {
            int rank = 0;
            for (int j = 0; j < sortedScore.size(); j++) {
                if (score[i] == sortedScore[j]) {
                    rank = sortedScore.size() - j;
                    break;
                }
            }
            if (rank == 1) {
                result.push_back("Gold Medal");
            } else if (rank == 2) {
                result.push_back("Silver Medal");
            } else if (rank == 3) {
                result.push_back("Bronze Medal");
            } else {
                result.push_back(to_string(rank));
            }
        }
        return result;
    }
};