class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        
        vector<string> result;
        vector<int> sorted = score;
        std::sort(sorted.begin(), sorted.end(), std::greater<int>());
        for (int i = 0; i < score.size(); i++) {
            int index = std::find(sorted.begin(), sorted.end(), score[i]) - sorted.begin();
            if (index == 0) {
                result.push_back("Gold Medal");
            } else if (index == 1) {
                result.push_back("Silver Medal");
            } else if (index == 2) {
                result.push_back("Bronze Medal");
            } else {
                result.push_back(std::to_string(index + 1));
            }
        }
        return result;
    }
};