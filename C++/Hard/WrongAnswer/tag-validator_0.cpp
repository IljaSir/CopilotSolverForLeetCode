class Solution {
public:
    bool isValid(string code) {
        
        if (code[0] != '<' || code[1] == '!' || code[1] == '/') return false;
        stack<string> stk;
        for (int i = 0; i < code.size(); ++i) {
            if (code[i] == '<') {
                if (code[i + 1] == '!') {
                    if (code.substr(i, 9) != "<![CDATA[") return false;
                    i += 9;
                    while (i < code.size() - 2) {
                        if (code.substr(i, 3) == "]]>") {
                            i += 2;
                            break;
                        }
                        i++;
                    }
                } else if (code[i + 1] == '/') {
                    i += 2;
                    string tag;
                    while (i < code.size() && code[i] != '>') {
                        if (code[i] < 'A' || code[i] > 'Z') return false;
                        tag += code[i++];
                    }
                    if (stk.empty() || stk.top() != tag) return false;
                    stk.pop();
                } else {
                    i++;
                    string tag;
                    while (i < code.size() && code[i] != '>') {
                        if (code[i] < 'A' || code[i] > 'Z' || tag.size() > 9) return false;
                        tag += code[i++];
                    }
                    stk.push(tag);
                }
            }
        }
        return stk.empty();
    }
};