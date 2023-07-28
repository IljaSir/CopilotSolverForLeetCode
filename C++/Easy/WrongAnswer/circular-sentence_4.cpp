class Solution {
public:
    bool isCircularSentence(string sentence) {
        
        int n = sentence.size();
        if (n == 0) return true;
        int i = 0;
        while (i < n && sentence[i] != ' ') i++;
        if (i == n) return true;
        int j = i + 1;
        while (j < n && sentence[j] != ' ') j++;
        if (j == n) return false;
        if (sentence[i - 1] != sentence[j]) return false;
        while (j < n) {
            i = j;
            while (j < n && sentence[j] != ' ') j++;
            if (j == n) return false;
            if (sentence[i - 1] != sentence[j]) return false;
            j++;
        }
        return true;
    }
};