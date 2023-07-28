class Solution {
public:
    string nearestPalindromic(string n) {
        
        int len = n.length();
        set<long long> candidates;
        candidates.insert((long long)pow(10, len) + 1);
        candidates.insert((long long)pow(10, len - 1) - 1);
        long long prefix = stoll(n.substr(0, (len + 1) / 2));
        for (int i = -1; i <= 1; i++) {
            string p = to_string(prefix + i);
            string pp = p + string(p.rbegin() + (len & 1), p.rend());
            candidates.insert(stoll(pp));
        }
        long long num = stoll(n), minDiff = INT_MAX, ans = 0;
        candidates.erase(num);
        for (long long p : candidates) {
            if (minDiff > abs(p - num)) {
                minDiff = abs(p - num);
                ans = p;
            } else if (minDiff == abs(p - num)) {
                ans = min(ans, p);
            }
        }
        return to_string(ans);
    }
};