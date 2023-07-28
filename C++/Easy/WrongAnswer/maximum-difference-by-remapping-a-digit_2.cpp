class Solution {
public:
    int minMaxDifference(int num) {
        
        string s = to_string(num);
        int n = s.size();
        int min = num;
        int max = num;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == s[i] - '0') continue;
                int newNum = stoi(s.substr(0, i) + to_string(j) + s.substr(i + 1, n - i - 1));
                if (newNum > max) max = newNum;
                if (newNum < min) min = newNum;
            }
        }
        return max - min;
    }
};