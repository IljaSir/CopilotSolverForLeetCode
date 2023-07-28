class Solution {
public:
    vector<string> twoEditWords(vector<string>& queries, vector<string>& dictionary) {
        
        unordered_set<string> dict(dictionary.begin(), dictionary.end());
        vector<string> result;
        for (const string& query : queries) {
            if (dict.count(query)) {
                result.push_back(query);
                continue;
            }
            bool found = false;
            for (int i = 0; i < query.size() && !found; ++i) {
                for (char c = 'a'; c <= 'z' && !found; ++c) {
                    if (c == query[i]) {
                        continue;
                    }
                    string tmp = query;
                    tmp[i] = c;
                    if (dict.count(tmp)) {
                        result.push_back(query);
                        found = true;
                    }
                }
            }
            if (found) {
                continue;
            }
            for (int i = 0; i < query.size() && !found; ++i) {
                for (int j = i + 1; j < query.size() && !found; ++j) {
                    for (char c1 = 'a'; c1 <= 'z' && !found; ++c1) {
                        for (char c2 = 'a'; c2 <= 'z' && !found; ++c2) {
                            if (c1 == query[i] && c2 == query[j]) {
                                continue;
                            }
                            string tmp = query;
                            tmp[i] = c1;
                            tmp[j] = c2;
                            if (dict.count(tmp)) {
                                result.push_back(query);
                                found = true;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
};