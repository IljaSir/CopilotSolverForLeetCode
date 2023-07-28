class Solution {
public:
    string reformatNumber(string number) {
        
        string ans;
        for (auto c : number) {
            if (c == '-' || c == ' ') {
                continue;
            }
            ans.push_back(c);
        }
        int len = ans.size();
        int i = 0;
        while (len - i > 4) {
            ans.insert(i + 3, "-");
            len++;
            i += 4;
        }
        if (len - i == 4) {
            ans.insert(i + 2, "-");
        }
        return ans;
    }
};