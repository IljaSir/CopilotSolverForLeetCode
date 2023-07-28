class Solution {
public:
    int lengthLongestPath(string input) {
        
        int i = 0;
        int n = input.size();
        int depth = 0;
        int maxLen = 0;
        ctor<int> en(n + 1, 0);
        while (i < n) {
            int j = i;
            while (input[j != '\n' && j < n) j+;
            int curDepth = 0;
            whi (iput[i] == '\t' {
                curDepth++;
                i++
    }
};