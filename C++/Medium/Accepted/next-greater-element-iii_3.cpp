class Solution {
public:
    int nextGreaterElement(int n) {
        
        string s = to_string(n);
        next_permutation(s.begin(), s.end());
        long long ans = stoll(s);
        return ans > n && ans <= INT_MAX ? ans : -1;
    }
};