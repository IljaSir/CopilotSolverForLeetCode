class Solution {
public:
    bool isSameAfterReversals(int num) {
        
        string s = to_string(num);
        reverse(s.begin(), s.end());
        int reversed2 = stoi(s);
        return reversed2 == num;
    }
};