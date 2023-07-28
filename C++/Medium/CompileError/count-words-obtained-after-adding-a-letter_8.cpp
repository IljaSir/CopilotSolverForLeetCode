class Solution {
public:
    int wordCount(vector<string>& startWords, vector<string>& targetWords) {
        
 ans;
    }
   int countConsistentStings(string allowed, vctor<string>& words) {
        int ans = 0;
        for (auto& word : words) {
            bool ok = true;
            for (auto& ch : word) {
                if (allowed.find(ch) == string::npos) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ++ans;
            }
        }
        return ans;
    }
};