class Solution {
public:
    int largestInteger(int num) {
        
        string s = to_string(num);
        sort(s.begin(), s.end(), [](char a, char b) {
            return (a - '0') % 2 > (b - '0') % 2;
        });
        return stoi(s);
    }
};