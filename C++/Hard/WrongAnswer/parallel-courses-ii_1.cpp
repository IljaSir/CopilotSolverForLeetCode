class Solution {
public:
    int minNumberOfSemesters(int n, vector<vector<int>>& relations, int k) {
        
        vector<int> indegree(n, 0);
        vector<unordered_set<int>> outdegree(n);
        for (auto& r : relations) {
            ++indegree[r[1] - 1];
            outdegree[r[0] - 1].insert(r[1] - 1);
        }
        vector<int> course(n, 0);
        for (int i = 0; i < n; ++i) {
            course[i] = i;
        }
        int semester = 0;
        while (!course.empty()) {
            int cnt = 0;
            vector<int> temp;
            for (int i = 0; i < course.size(); ++i) {
                if (indegree[course[i]] == 0) {
                    ++cnt;
                    if (cnt > k) {
                        break;
                    }
                    for (auto& j : outdegree[course[i]]) {
                        --indegree[j];
                    }
                } else {
                    temp.push_back(course[i]);
                }
            }
            course = temp;
            ++semester;
        }
        return semester;
    }
};