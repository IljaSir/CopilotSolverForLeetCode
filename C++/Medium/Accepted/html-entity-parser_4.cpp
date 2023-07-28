class Solution {
public:
    string entityParser(string text) {
        
        string result;
        for (int i = 0; i < text.size(); ++i) {
            if (text[i] == '&') {
                if (text.substr(i, 6) == "&quot;") {
                    result += '\"';
                    i += 5;
                } else if (text.substr(i, 6) == "&apos;") {
                    result += '\'';
                    i += 5;
                } else if (text.substr(i, 5) == "&amp;") {
                    result += '&';
                    i += 4;
                } else if (text.substr(i, 4) == "&gt;") {
                    result += '>';
                    i += 3;
                } else if (text.substr(i, 4) == "&lt;") {
                    result += '<';
                    i += 3;
                } else if (text.substr(i, 7) == "&frasl;") {
                    result += '/';
                    i += 6;
                } else {
                    result += text[i];
                }
            } else {
                result += text[i];
            }
        }
        return result;
    }
};