class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        
        int cnt = 0;
        for (auto &word : words) {
            bool flag = true;
            for (char ch : word) {
                if (allowed.find(ch) == string::npos) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        return cnt;
    }
};