class Solution {
public:
    int calPoints(vector<string>& operations) {
        
        int res = 0;
        vector<int> scores;
        for (auto op : operations) {
            if (op == "+") {
                scores.push_back(scores[scores.size() - 1] + scores[scores.size() - 2]);
            } else if (op == "D") {
                scores.push_back(scores[scores.size() - 1] * 2);
            } else if (op == "C") {
                scores.pop_back();
            } else {
                scores.push_back(stoi(op));
            }
        }
        for (auto score : scores) {
            res += score;
        }
        return res;
    }
};