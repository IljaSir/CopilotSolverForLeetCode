class Solution {
public:
    bool isSumEqual(string firstWord, string secondWord, string targetWord) {
        
        int f = 0;
        int s = 0;
        int t = 0;
        for (auto c : firstWord) {
            f = f * 10 + c - 'a';
        }
        for (auto c : secondWord) {
            s = s * 10 + c - 'a';
        }
        for (auto c : targetWord) {
            t = t * 10 + c - 'a';
        }
        return f + s == t;
    }
};