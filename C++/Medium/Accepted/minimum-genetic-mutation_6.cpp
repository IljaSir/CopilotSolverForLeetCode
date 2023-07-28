class Solution {
public:
    int minMutation(string startGene, string endGene, vector<string>& bank) {
        
        set<string> s(bank.begin(), bank.end());
        if (s.find(endGene) == s.end()) return -1;
        int res = 0;
        queue<string> q;
        q.push(startGene);
        while (!q.empty()) {
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                string cur = q.front();
                q.pop();
                if (cur == endGene) return res;
                for (int j = 0; j < cur.size(); ++j) {
                    char c = cur[j];
                    for (char ch : {'A', 'C', 'G', 'T'}) {
                        if (ch == c) continue;
                        cur[j] = ch;
                        if (s.find(cur) != s.end()) {
                            q.push(cur);
                            s.erase(cur);
                        }
                    }
                    cur[j] = c;
                }
            }
            ++res;
        }
        return -1;
    }
};