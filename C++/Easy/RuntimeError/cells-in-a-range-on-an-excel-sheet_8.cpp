class Solution {
public:
    vector<string> cellsInRange(string s) {
        
        int i = 0;
        string a, b;
        while(s[i] != ':') a += s[i++];
        while(i < s.length()) b += s[i++];
        string c1, c2, r1, r2;
        i = 0;
        while(i < a.length() && isalpha(a[i])) c1 += a[i++];
        while(i < a.length()) r1 += a[i++];
        i = 0;
        while(i < b.length() && isalpha(b[i])) c2 += b[i++];
        while(i < b.length()) r2 += b[i++];
        int r1i = stoi(r1);
        int r2i = stoi(r2);
        int c1i = 0, c2i = 0;
        for(int i = 0; i < c1.length(); i++) c1i = c1i * 26 + c1[i] - 'A' + 1;
        for(int i = 0; i < c2.length(); i++) c2i = c2i * 26 + c2[i] - 'A' + 1;
        vector<string> ans;
        for(int i = r1i; i <= r2i; i++) {
            for(int j = c1i; j <= c2i; j++) {
                string c = "", r = "";
                int t = j;
                while(t > 0) {
                    c = (char)((t - 1) % 26 + 'A') + c;
                    t = (t - 1) / 26;
                }
                r = to_string(i);
                ans.push_back(c + r);
            }
        }
        return ans;
    }
};