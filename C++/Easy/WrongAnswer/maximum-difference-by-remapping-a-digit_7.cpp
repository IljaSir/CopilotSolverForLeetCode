class Solution {
public:
    int minMaxDifference(int num) {
        
        string s = to_string(num);
        int n = s.size();
        int minNum = INT_MAX, maxNum = INT_MIN;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if (s[i] == '0' + j) continue;
                string t = s;
                for (int k = i; k < n; k++) {
                    if (t[k] == '0' + j) t[k] = s[i];
                }
                int x = stoi(t);
                minNum = min(minNum, x);
                maxNum = max(maxNum, x);
            }
        }
        return maxNum - minNum;
    }
};