class Solution {
public:
    int nextGreaterElement(int n) {
        
        string s = to_string(n);
        if (next_permutation(s.begin(), s.end())) {
            long long r = stoll(s);
            if (r > INT_MAX) return -1;
            return r;
        }
        return -1;
    }
};