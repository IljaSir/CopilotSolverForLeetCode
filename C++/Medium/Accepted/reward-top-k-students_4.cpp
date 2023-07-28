class Solution {
public:
    vector<int> topStudents(vector<string>& positive_feedback, vector<string>& negative_feedback, vector<string>& report, vector<int>& student_id, int k) {
        
        unordered_map<string, int> positive, negative;
        for (auto& word : positive_feedback) positive[word] = 3;
        for (auto& word : negative_feedback) negative[word] = -1;
        int n = report.size();
        vector<int> score(n, 0);
        for (int i = 0; i < n; ++i) {
            istringstream iss(report[i]);
            string word;
            while (iss >> word) {
                if (positive.find(word) != positive.end()) score[i] += positive[word];
                else if (negative.find(word) != negative.end()) score[i] += negative[word];
            }
        }
        vector<pair<int, int>> pairs;
        for (int i = 0; i < n; ++i) pairs.push_back({score[i], student_id[i]});
        sort(pairs.begin(), pairs.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
            if (a.first != b.first) return a.first > b.first;
            return a.second < b.second;
        });
        vector<int> res;
        for (int i = 0; i < k; ++i) res.push_back(pairs[i].second);
        return res;
    }
};