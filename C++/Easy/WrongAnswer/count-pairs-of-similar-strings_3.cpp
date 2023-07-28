class Solution {
public:
    int similarPairs(vector<string>& words) {
        
        int n = words.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }
    bool isSimilar(string& a, string& b) {
        if (a.length() != b.length()) {
            return false;
        }
        int n = a.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                count++;
            }
        }
        return count <= 2;
    }
};