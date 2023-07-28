class Solution {
public:
    vector<int> topStudents(vector<string>& positive_feedback, vector<string>& negative_feedback, vector<string>& report, vector<int>& student_id, int k) {
        
        vector<int> res;
        unordered_map<string, int> positive;
        unordered_map<string, int> negative;
        for (auto& word : positive_feedback) positive[word] = 1;
        for (auto& word : negative_feedback) negative[word] = 1;
        unordered_map<int, int> score;
        for (int i = 0; i < report.size(); ++i) {
            istringstream ss(report[i]);
            string word;
            while (ss >> word) {
                if (positive.count(word)) ++score[student_id[i]];
                else if (negative.count(word)) --score[student_id[i]];
            }
        }
        priority_queue<pair<int, int>> pq;
        for (auto& [id, s] : score) {
            pq.emplace(s, id);
        }
        while (k--) {
            res.push_back(pq.top().second);
            pq.pop();
        }
        return res;
    }
};