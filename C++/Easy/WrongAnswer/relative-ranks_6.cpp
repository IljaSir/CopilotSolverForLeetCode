class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        
        vector<string> result;
        std::map<int, int> rank;
        for (int i = 0; i < score.size(); i++) {
            rank[score[i]] = i;
        }
        int i = 0;
        for (auto it = rank.rbegin(); it != rank.rend(); it++) {
            if (i == 0) {
                result.push_back("Gold Medal");
            } else if (i == 1) {
                result.push_back("Silver Medal");
            } else if (i == 2) {
                result.push_back("Bronze Medal");
            } else {
                result.push_back(std::to_string(i + 1));
            }
            i++;
        }
        vector<string> newResult(score.size());
        for (int i = 0; i < result.size(); i++) {
            newResult[rank[score[i]]] = result[i];
        }
        return newResult;
    }
};