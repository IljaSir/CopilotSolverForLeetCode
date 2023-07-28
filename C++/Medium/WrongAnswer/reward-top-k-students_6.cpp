class Solution {
public:
    vector<int> topStudents(vector<string>& positive_feedback, vector<string>& negative_feedback, vector<string>& report, vector<int>& student_id, int k) {
        
        vector<int> res;
        unordered_map<string, int> positive;
        unordered_map<string, int> negative;
        for (auto& str : positive_feedback) positive[str] = 1;
        for (auto& str : negative_feedback) negative[str] = 1;
        unordered_map<int, int> students;
        for (int i = 0; i < report.size(); ++i) {
            int id = student_id[i];
            istringstream iss(report[i]);
            string word;
            while (iss >> word) {
                if (positive.count(word)) ++students[id];
                else if (negative.count(word)) --students[id];
            }
        }
        vector<pair<int, int>> v;
        for (auto& p : students) v.push_back(p);
        sort(v.begin(), v.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
            if (a.second == b.second) return a.first < b.first;
            return a.second > b.second;
        });
        for (int i = 0; i < k; ++i) res.push_back(v[i].first);
        return res;
    }
};