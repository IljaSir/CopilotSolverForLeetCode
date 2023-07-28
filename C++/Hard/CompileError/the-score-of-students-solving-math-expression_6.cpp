class Solution {
public:
    int scoreOfStudents(string s, vector<int>& answers) {
        
        int ans = 0;
        int n = s.length();
        int correct = calculate(s);
        for (int a : answers) {
            if (a == correct) {
                ans += 5;
            } else {
                // check if the answer is a combination of correct answers
                vector<int> sub = getSub(s);
                bool ok = false;
                for (int i = 0; i < sub.size(); ++i) {
                    for (int j = i + 1; j < sub.size(); ++j) {
                        int t = calculate(sub[i]) + calculate(sub[j]);
                        if (t == a) {
                            ok = true;
                            break;
                        }
                    }
                    if (ok) break;
                }
                if (ok) ans += 2;
            }
        }
        return ans;
    }
    
    vector<string> getSub(string s) {
        vector<string> res;
        for (int i = 0; i < s.length(); ++i) {
            if (s[i] == '+' || s[i] == '*') {
                res.push_back(s.substr(0, i));
                res.push_back(s.substr(i + 1));
            }
        }
        return res;
    }
    
    int calculate(string s) {
        int num = 0;
        int ans = 0;
        char op = '+';
        for (int i = 0; i < s.length(); ++i) {
            if (s[i] >= '0' && s[i] <= '9') {
                num = num * 10 + (s[i] - '0');
            } else {
                if (op == '+') {
                    ans += num;
                } else {
                    ans *= num;
                }
                op = s[i];
                num = 0;
            }
        }
        if (op == '+') {
            ans += num;
        } else {
            ans *= num;
        }
        return ans;
    }
};