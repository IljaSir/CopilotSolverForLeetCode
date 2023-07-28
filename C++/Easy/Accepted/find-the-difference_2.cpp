class Solution {
public:
    char findTheDifference(string s, string t) {
        
        int sum1 = 0;
        int sum2 = 0;
        for (auto c : s) {
            sum1 += c;
        }
        for (auto c : t) {
            sum2 += c;
        }
        return sum2 - sum1;
    }
};