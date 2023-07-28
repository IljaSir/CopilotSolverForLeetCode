class Solution {
public:
    vector<int> topStudents(vector<string>& positive_feedback, vector<string>& negative_feedback, vector<string>& report, vector<int>& student_id, int k) {
        
        unordered_map<string, int> pos;
        unordered_map<string, int> neg;
        for (auto& s : positive_feedback) {
            pos[s]++;
        }
        for (auto& s : negative_feedback) {
            neg[s]++;
        }
        unordered_map<int, int> score;
        for (int i = 0; i < report.size(); i++) {
            int id = student_id[i];
            int s = 0;
            stringstream ss(report[i]);
            string word;
            while (ss >> word) {
                if (pos.count(word)) {
                    s += 3;
                }
                else if (neg.count(word)) {
                    s -= 1;
                }
            }
            score[id] += s;
        }
        vector<pair<int, int>> v;
        for (auto& p : score) {
            v.push_back({p.second, p.first});
        }
        sort(v.begin(), v.end(), greater<pair<int, int>>());
        vector<int> ans;
        for (int i = 0; i < k; i++) {
            ans.push_back(v[i].second);
        }
        return ans;
    }
};