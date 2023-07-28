class Solution {
public:
    vector<vector<int>> substringXorQueries(string s, vector<vector<int>>& queries) {
        
        vector<vector<int>> result;
        int n = s.size();
        vector<int> prefix(n, 0);
        prefix[0] = s[0] - '0';
        for (int i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1] ^ (s[i] - '0');
        }
        for (auto query : queries) {
            int first = query[0];
            int second = query[1];
            int left = -1;
            int right = -1;
            for (int i = 0; i < n; ++i) {
                if (i == 0) {
                    if (prefix[i] == second && (first == 0 || s[i] == '1')) {
                        left = i;
                        right = i;
                        break;
                    }
                } else {
                    int val = prefix[i] ^ prefix[i - 1];
                    if (val == second && (first == 0 || s[i] == '1')) {
                        left = i;
                        right = i;
                        break;
                    }
                }
            }
            result.push_back({left, right});
        }
        return result;
    }
};