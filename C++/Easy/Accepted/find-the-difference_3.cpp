class Solution {
public:
    char findTheDifference(string s, string t) {
        
        int sum = 0;
        for (auto c : s) {
            sum += c;
        }
        for (auto c : t) {
            sum -= c;
        }
        return -sum;
    }
};