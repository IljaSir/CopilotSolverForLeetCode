class Solution {
public:
    vector<int> processQueries(vector<int>& queries, int m) {
        
        vector<int> p;
        vector<int> result;
        for (int i = 0; i < m; i++) {
            p.push_back(i + 1);
        }
        for (int i = 0; i < queries.size(); i++) {
            int index = 0;
            for (int j = 0; j < p.size(); j++) {
                if (queries[i] == p[j]) {
                    index = j;
                    break;
                }
            }
            result.push_back(index);
            p.insert(p.begin(), p[index]);
            p.erase(p.begin() + index + 1);
        }
        return result;
    }
};