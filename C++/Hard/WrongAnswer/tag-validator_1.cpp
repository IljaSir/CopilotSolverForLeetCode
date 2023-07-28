class Solution {
public:
    bool isValid(string code) {
        
        int state = 0;
        int i = 0;
        int len = code.size();
        string tag;
        stack<string> st;
        while (i < len) {
            if (i < len - 1 && code[i] == '<' && code[i + 1] == '!') {
                if (code.substr(i, 9) != "<![CDATA[") return false;
                int j = i + 9;
                while (j + 2 < len && code.substr(j, 3) != "]]>") j++;
                if (j + 2 >= len) return false;
                i = j + 3;
            } else if (code[i] == '<') {
                if (i + 1 < len && code[i + 1] == '/') {
                    int j = i + 2;
                    while (j < len && code[j] != '>') j++;
                    if (j >= len) return false;
                    string tag2 = code.substr(i + 2, j - i - 2);
                    if (tag2.size() < 1 || tag2.size() > 9) return false;
                    for (auto c : tag2) if (c < 'A' || c > 'Z') return false;
                    if (st.empty() || st.top() != tag2) return false;
                    st.pop();
                    if (st.empty()) state = 0;
                    i = j + 1;
                } else {
                    int j = i + 1;
                    while (j < len && code[j] != '>') j++;
                    if (j >= len) return false;
                    tag = code.substr(i + 1, j - i - 1);
                    if (tag.size() < 1 || tag.size() > 9) return false;
                    for (auto c : tag) if (c < 'A' || c > 'Z') return false;
                    st.push(tag);
                    i = j + 1;
                }
            } else {
                int j = i;
                while (j < len && code[j] != '<') j++;
                i = j;
            }
        }
        return st.empty() && state == 0;
    }
};