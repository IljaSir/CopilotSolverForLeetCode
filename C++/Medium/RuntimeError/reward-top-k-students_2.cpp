class Solution {
public:
    vector<int> topStudents(vector<string>& positive_feedback, vector<string>& negative_feedback, vector<string>& report, vector<int>& student_id, int k) {
        
        unordered_map<string, int> positive;
        for (auto& w : positive_feedback) positive[w]++;
        unordered_map<string, int> negative;
        for (auto& w : negative_feedback) negative[w]++;
        unordered_map<int, int> scores;
        for (int i = 0; i < report.size(); ++i) {
            istringstream iss(report[i]);
            string word;
            while (iss >> word) {
                if (positive.count(word)) scores[student_id[i]] += 3;
                if (negative.count(word)) scores[student_id[i]] -= 1;
            }
        }
        vector<pair<int, int>> score;
        for (auto& p : scores) {
            score.push_back({p.second, p.first});
        }
        sort(score.begin(), score.end(), [](const auto& a, const auto& b) {
            return a.first > b.first || (a.first == b.first && a.second < b.second);
        });
        vector<int> ans;
        for (int i = 0; i < k; ++i) {
            ans.push_back(score[i].second);
        }
        return ans;
    }
};