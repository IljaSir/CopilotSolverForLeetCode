class Solution {
public:
    int calPoints(vector<string>& operations) {
        
        int sum = 0;
        vector<int> scores;
        for(string op : operations) {
            if(op == "+") {
                int last = scores[scores.size() - 1];
                int second_last = scores[scores.size() - 2];
                int new_score = last + second_last;
                scores.push_back(new_score);
                sum += new_score;
            } else if(op == "D") {
                int last = scores[scores.size() - 1];
                int new_score = last * 2;
                scores.push_back(new_score);
                sum += new_score;
            } else if(op == "C") {
                int last = scores[scores.size() - 1];
                scores.pop_back();
                sum -= last;
            } else {
                int new_score = stoi(op);
                scores.push_back(new_score);
                sum += new_score;
            }
        }
        return sum;
    }
};