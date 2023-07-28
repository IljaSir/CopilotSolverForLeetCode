class Solution {
public:
    string reorganizeString(string s) {
        
        int n = s.size();
        vector<int> cnt(26, 0);
        for (char c : s) {
            ++cnt[c - 'a'];
        }
        priority_queue<pair<int, char>> pq;
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] > 0) {
                pq.push(make_pair(cnt[i], i + 'a'));
            }
        }
        string res;
        while (!pq.empty()) {
            auto p = pq.top();
            pq.pop();
            if (res.empty() || res.back() != p.second) {
                res += p.second;
                if (--p.first > 0) {
                    pq.push(p);
                }
            } else {
                if (pq.empty()) {
                    return "";
                }
                auto q = pq.top();
                pq.pop();
                res += q.second;
                if (--q.first > 0) {
                    pq.push(q);
                }
                pq.push(p);
            }
        }
        return res;
    }
};