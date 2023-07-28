class Solution {
public:
    int calPoints(vector<string>& operations) {
        
        vector<int> scores;
        for (auto op : operations) {
            if (op == "C") {
                scores.pop_back();
            } else if (op == "D") {
                scores.push_back(scores.back() * 2);
            } else if (op == "+") {
                scores.push_back(scores.back() + scores[scores.size() - 2]);
            } else {
                scores.push_back(stoi(op));
            }
        }
        int sum = 0;
        for (auto score : scores) {
            sum += score;
        }
        return sum;
    }
};