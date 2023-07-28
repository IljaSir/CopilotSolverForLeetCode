class Solution {
public:
    long long sumScores(string s) {
        
        long long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.length() - i;
        }
        return sum;
    }
};