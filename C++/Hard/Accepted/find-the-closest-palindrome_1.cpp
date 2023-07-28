class Solution {
public:
    string nearestPalindromic(string n) {
        
        int len = n.length();
        if (len == 1) {
            return to_string(stoi(n) - 1);
        }
        string s = n.substr(0, (len + 1) / 2);
        long long num = stoll(s);
        vector<long long> candidates;
        candidates.push_back((long long)pow(10, len) + 1);
        candidates.push_back((long long)pow(10, len - 1) - 1);
        for (int i = -1; i <= 1; i++) {
            string t = to_string(num + i);
            string rev = t;
            reverse(rev.begin(), rev.end());
            candidates.push_back(stoll(t + (len % 2 == 0 ? rev : rev.substr(1))));
        }
        long long val = stoll(n);
        long long diff = LONG_MAX;
        string ans;
        for (long long candidate : candidates) {
            if (candidate == val) {
                continue;
            }
            long long d = abs(candidate - val);
            if (d < diff) {
                diff = d;
                ans = to_string(candidate);
            } else if (d == diff && candidate < stoll(ans)) {
                ans = to_string(candidate);
            }
        }
        return ans;
    }
};