class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        
        string ans;
        priority_queue<pair<int, char>> pq;
        if (a) pq.push({a, 'a'});
        if (b) pq.push({b, 'b'});
        if (c) pq.push({c, 'c'});
        while (pq.size() > 1) {
            auto [cnt1, ch1] = pq.top(); pq.pop();
            auto [cnt2, ch2] = pq.top(); pq.pop();
            if (cnt1 >= 2) {
                ans += ch1;
                ans += ch1;
                cnt1 -= 2;
            } else {
                ans += ch1;
                --cnt1;
            }
            if (cnt2 >= 2) {
                ans += ch2;
                ans += ch2;
                cnt2 -= 2;
            } else {
                ans += ch2;
                --cnt2;
            }
            if (cnt1) pq.push({cnt1, ch1});
            if (cnt2) pq.push({cnt2, ch2});
        }
        if (pq.empty()) return ans;
        auto [cnt, ch] = pq.top(); pq.pop();
        if (cnt >= 2 && ans.back() != ch) {
            ans += ch;
            ans += ch;
            --cnt;
        }
        if (cnt) ans += ch;
        return ans;
    }
};