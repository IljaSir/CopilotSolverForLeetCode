class Solution {
public:
    vector<int> topStudents(vector<string>& positive_feedback, vector<string>& negative_feedback, vector<string>& report, vector<int>& student_id, int k) {
        
        vector<int> res;
        unordered_map<string, int> posMap;
        unordered_map<string, int> negMap;
        unordered_map<int, int> stuMap;
        for (string& word : positive_feedback) {
            posMap[word]++;
        }
        for (string& word : negative_feedback) {
            negMap[word]++;
        }
        for (int i = 0; i < report.size(); ++i) {
            stringstream ss(report[i]);
            string word;
            while (ss >> word) {
                if (posMap.find(word) != posMap.end()) {
                    stuMap[student_id[i]] += 3;
                }
                if (negMap.find(word) != negMap.end()) {
                    stuMap[student_id[i]] -= 1;
                }
            }
        }
        vector<pair<int, int>> stuVec;
        for (auto& [id, score] : stuMap) {
            stuVec.push_back({score, id});
        }
        sort(stuVec.begin(), stuVec.end(), [](pair<int, int>& a, pair<int, int>& b) {
            if (a.first == b.first) {
                return a.second < b.second;
            }
            return a.first > b.first;
        });
        for (int i = 0; i < k; ++i) {
            res.push_back(stuVec[i].second);
        }
        return res;
    }
};