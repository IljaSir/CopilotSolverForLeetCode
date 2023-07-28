class Solution {
public:
    string reorganizeString(string s) {
        
        unordered_map<char, int> charCount;
        for (char c : s) {
            charCount[c]++;
        }
        priority_queue<pair<int, char>> pq;
        for (auto& p : charCount) {
            pq.push({p.second, p.first});
        }
        string res;
        while (pq.size() >= 2) {
            auto p1 = pq.top();
            pq.pop();
            auto p2 = pq.top();
            pq.pop();
            res.push_back(p1.second);
            res.push_back(p2.second);
            if (--p1.first > 0) {
                pq.push(p1);
            }
            if (--p2.first > 0) {
                pq.push(p2);
            }
        }
        if (!pq.empty()) {
            res.push_back(pq.top().second);
        }
        return res.size() == s.size() ? res : "";
    }
};