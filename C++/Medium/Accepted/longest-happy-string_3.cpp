class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        
        string res;
        priority_queue<pair<int, char>> q;
        if (a > 0) {
            q.push({a, 'a'});
        }
        if (b > 0) {
            q.push({b, 'b'});
        }
        if (c > 0) {
            q.push({c, 'c'});
        }
        while (!q.empty()) {
            auto [count1, ch1] = q.top();
            q.pop();
            if (res.size() >= 2 && res[res.size() - 1] == ch1 && res[res.size() - 2] == ch1) {
                if (q.empty()) {
                    break;
                }
                auto [count2, ch2] = q.top();
                q.pop();
                res.push_back(ch2);
                if (--count2 > 0) {
                    q.push({count2, ch2});
                }
                q.push({count1, ch1});
            } else {
                res.push_back(ch1);
                if (--count1 > 0) {
                    q.push({count1, ch1});
                }
            }
        }
        return res;
    }
};