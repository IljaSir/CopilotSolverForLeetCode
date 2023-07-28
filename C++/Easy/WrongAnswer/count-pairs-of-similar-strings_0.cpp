class Solution {
public:
    int similarPairs(vector<string>& words) {
        
        int count = 0;
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (isSimilar(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }
    
    bool isSimilar(string a, string b) {
        if (a.length() != b.length()) {
            return false;
        }
        
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a[i] != b[i]) {
                count++;
            }
        }
        return count <= 2;
    }
};