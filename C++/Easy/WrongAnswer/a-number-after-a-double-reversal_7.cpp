class Solution {
public:
    bool isSameAfterReversals(int num) {
        
        string s = to_string(num);
        reverse(s.begin(), s.end());
        int rev = stoi(s);
        return rev == num;
    }
};