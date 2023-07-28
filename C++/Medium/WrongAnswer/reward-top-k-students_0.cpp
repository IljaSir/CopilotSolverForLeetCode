class Solution {
public:
    vector<int> topStudents(vector<string>& positive_feedback, vector<string>& negative_feedback, vector<string>& report, vector<int>& student_id, int k) {
        
        unordered_map<string, int> pos;
        for (auto& s : positive_feedback) pos[s] = 3;
        unordered_map<string, int> neg;
        for (auto& s : negative_feedback) neg[s] = -1;
        unordered_map<int, int> scores;
        for (int i = 0; i < report.size(); i++) {
            int id = student_id[i];
            int score = 0;
            stringstream ss(report[i]);
            string word;
            while (ss >> word) {
                if (pos.count(word)) score += pos[word];
                else if (neg.count(word)) score += neg[word];
            }
            scores[id] += score;
        }
        vector<pair<int, int>> vp;
        for (auto& [id, score] : scores) vp.push_back({score, id});
        sort(vp.rbegin(), vp.rend());
        vector<int> res;
        for (int i = 0; i < k; i++) res.push_back(vp[i].second);
        return res;
    }
};