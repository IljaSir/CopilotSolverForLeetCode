class Solution {
public:
    int calPoints(vector<string>& operations) {
        
        int sum = 0;
        vector<int> scores;
        for (int i = 0; i < operations.size(); i++) {
            if (operations[i] == "C") {
                sum -= scores.back();
                scores.pop_back();
            } else if (operations[i] == "D") {
                scores.push_back(scores.back() * 2);
                sum += scores.back();
            } else if (operations[i] == "+") {
                scores.push_back(scores[scores.size() - 1] + scores[scores.size() - 2]);
                sum += scores.back();
            } else {
                scores.push_back(stoi(operations[i]));
                sum += scores.back();
            }
        }
        return sum;
    }
};