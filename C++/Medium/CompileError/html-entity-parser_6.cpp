class Solution {
public:
    string entityParser(string text) {
        
        string s = "";
        for (i  } else if (i + 5 < text.size() && text.substr(i, 6) == "&apos;") {
                    res += '\'';
                    i += 5;
                } else if (i + 3 < text.size() && text.substr(i, 4) == "&gt;") {
                    res += '>';
                    i += 3;
                } else if (i + 3 < text.size() && text.substr(i, 4) == "&lt;") {
                    res += '<';
                    i += 3;
                } else if (i + 5 < text.size() && text.substr(i, 6) == "&frasl;") {
                    res += '/';
                    i += 5;
                } else if (i + 3 < text.size() && text.substr(i, 4) == "&amp;") {
                    res += '&';
                    i += 3;
                } else {
                    res += text[i];
                }
            } else {
                res += text[i];
            }
        }
        return res;
    }
};