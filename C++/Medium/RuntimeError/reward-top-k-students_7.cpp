class Solution {
public:
    vector<int> topStudents(vector<string>& positive_feedback, vector<string>& negative_feedback, vector<string>& report, vector<int>& student_id, int k) {
        
        map<string, int> positive;
        map<string, int> negative;
        map<int, int> points;
        for (string &word: positive_feedback) {
            positive[word] = 1;
        }
        for (string &word: negative_feedback) {
            negative[word] = 1;
        }
        for (int i = 0; i < report.size(); ++i) {
            istringstream iss(report[i]);
            string word;
            while (iss >> word) {
                if (positive.count(word)) {
                    points[student_id[i]] += 3;
                }
                if (negative.count(word)) {
                    points[student_id[i]] -= 1;
                }
            }
        }
        vector<pair<int, int>> v;
        for (auto &p: points) {
            v.push_back({p.second, p.first});
        }
        sort(v.begin(), v.end(), [](const pair<int, int> &p1, const pair<int, int> &p2) {
            if (p1.first == p2.first) {
                return p1.second < p2.second;
            }
            return p1.first > p2.first;
        });
        vector<int> ans;
        for (int i = 0; i < k; ++i) {
            ans.push_back(v[i].second);
        }
        return ans;
    }
};