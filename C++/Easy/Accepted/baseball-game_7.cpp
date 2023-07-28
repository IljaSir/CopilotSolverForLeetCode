class Solution {
public:
    int calPoints(vector<string>& operations) {
        
        int sum = 0;
        vector<int> score;
        for (auto& op : operations) {
            if (op == "C") {
                sum -= score.back();
                score.pop_back();
            } else if (op == "D") {
                score.push_back(score.back() * 2);
                sum += score.back();
            } else if (op == "+") {
                score.push_back(score.back() + score[score.size() - 2]);
                sum += score.back();
            } else {
                score.push_back(stoi(op));
                sum += score.back();
            }
        }
        return sum;
    }
};