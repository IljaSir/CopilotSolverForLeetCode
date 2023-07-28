class Solution {
public:
    int superpalindromesInRange(string left, string right) {
        
        long long L = stoll(left), R = stoll(right);
        int MAGIC = 100000;
        vector<long long> candidates;
        // Count odd length;
        for (int k = 1; k < MAGIC; ++k) {
            string s = to_string(k);
            for (int i = s.size() - 2; i >= 0; --i)
                s += s[i];
            long long v = stoll(s);
            v *= v;
            if (v > R) break;
            if (v >= L && isPalindrome(v))
                candidates.push_back(v);
        }
        // Count even length;
        for (int k = 1; k < MAGIC; ++k) {
            string s = to_string(k);
            for (int i = s.size() - 1; i >= 0; --i)
                s += s[i];
            long long v = stoll(s);
            v *= v;
            if (v > R) break;
            if (v >= L && isPalindrome(v))
                candidates.push_back(v);
        }
        return candidates.size();
    }
};