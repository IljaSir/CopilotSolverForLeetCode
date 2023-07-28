class Solution {
public:
    int nextGreaterElement(int n) {
        
        string s = to_string(n);
        next_permutation(s.begin(), s.end());
        try {
            return stoi(s) > n ? stoi(s) : -1;
        } catch (exception e) {
            return -1;
        }
    }
};