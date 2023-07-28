class Solution {
public:
    string reorganizeString(string s) {
        
        unordered_map<char, int> freq;
        for (auto c : s) {
            freq[c]++;
        }
        priority_queue<pair<int, char>> pq;
        for (auto it : freq) {
            pq.push({it.second, it.first});
        }
        string res;
        while (!pq.empty()) {
            auto p1 = pq.top();
            pq.pop();
            if (res.empty() || res.back() != p1.second) {
                res += p1.second;
                if (--p1.first > 0) {
                    pq.push(p1);
                }
            } else {
                if (pq.empty()) {
                    return "";
                }
                auto p2 = pq.top();
                pq.pop();
                res += p2.second;
                if (--p2.first > 0) {
                    pq.push(p2);
                }
                pq.push(p1);
            }
        }
        return res;
    }
};