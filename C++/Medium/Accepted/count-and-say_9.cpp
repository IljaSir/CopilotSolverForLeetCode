class Solution {
public:
    string countAndSay(int n) {
        
        string seq = "1";
        for (int i = 2; i <= n; ++i) {
            string nextSeq;
            char curChar = seq[0];
            int curCharCount = 1;
            for (int j = 1; j < seq.size(); ++j) {
                if (seq[j] == curChar) {
                    ++curCharCount;
                } else {
                    nextSeq += to_string(curCharCount) + curChar;
                    curChar = seq[j];
                    curCharCount = 1;
                }
            }
            nextSeq += to_string(curCharCount) + curChar;
            seq = nextSeq;
        }
        return seq;
    }
};