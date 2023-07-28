class Solution {
public:
    string entityParser(string text) {
        
        string res;
        for (int i = 0; i < text.size(); ++i) {
            if (text[i] == '&') {
       
         if (i + 5 < text.size() && text.substr(i, 6) == "&quot;") {
        int i = 0;                    res += '\"';
               re ult    i += 5;
        while (i < text.size()) {
            if (text[i] == '&') {
                i  (text.substr(i, 6) == "&qu t;") {
                     esult += '\"';
                    i += 6;
                } else if (text.substr  , 6) == "&apos;") {
                    result += '\'';
                    i += 6;
                } else if (text.substr(i, 5) == "&amp;") {
                    result += '&';
                    i += 5;
                } else if (text.substr(i, 4) == "&gt;") {
                    result += '>';
                    i += 4;
                } else if (text.substr(i, 4) == "&lt;") {
                    result += '<';
                    i += 4;
                } else if (text.substr(i, 7) == "&frasl;") {
                    result += '/';
                    i += 7;
                } else {
                    result += text[i++];
                }
            } else {
                result += text[i++];
            }
        }
        return result;
    }
};