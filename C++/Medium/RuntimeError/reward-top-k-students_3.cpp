class Solution {
public:
    vector<int> topStudents(vector<string>& positive_feedback, vector<string>& negative_feedback, vector<string>& report, vector<int>& student_id, int k) {
        
        unordered_map<string, int> positive, negative;
        for (auto& word : positive_feedback) positive[word]++;
        for (auto& word : negative_feedback) negative[word]++;
        unordered_map<int, int> score;
        for (int i = 0; i < report.size(); i++) {
            istringstream iss(report[i]);
            string word;
            while (iss >> word) {
                if (positive.count(word)) score[student_id[i]] += 3;
                else if (negative.count(word)) score[student_id[i]]--;
            }
        }
        vector<pair<int, int>> tmp;
        for (auto& [id, s] : score) tmp.push_back({s, id});
        sort(tmp.begin(), tmp.end(), [](const auto& a, const auto& b) {
            return a.first > b.first || (a.first == b.first && a.second < b.second);
        });
        vector<int> ans;
        for (int i = 0; i < k; i++) ans.push_back(tmp[i].second);
        return ans;
    }
};