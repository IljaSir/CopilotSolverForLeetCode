class Solution {
public:
    string entityParser(string text) {
        
        string s = "";
        for (int i = 0; i < text.size(); i++) {
            if (text[i] == '&') {
                if (i + 5 < text.size() && text[i + 1] == 'a' && text[i + 2] == 'm' && text[i + 3] == 'p' && text[i + 4] == ';') {
                    s += '&';
                    i += 4;
                } else if (i + 6 < text.size() && text[i + 1] == 'q' && text[i + 2] == 'u' && text[i + 3] == 'o' && text[i + 4] == 't' && text[i + 5] == ';') {
                    s += '"';
                    i += 5;
                } else if (i + 6 < text.size() && text[i + 1] == 'a' && text[i + 2] == 'p' && text[i + 3] == 'o' && text[i + 4] == 's' && text[i + 5] == ';') {
                    s += '\'';
                    i += 5;
                } else if (i + 5 < text.size() && text[i + 1] == 'g' && text[i + 2] == 't' && text[i + 3] == ';') {
                    s += '>';
                    i += 3;
                } else if (i + 5 < text.size() && text[i + 1] == 'l' && text[i + 2] == 't' && text[i + 3] == ';') {
                    s += '<';
                    i += 3;
                } else if (i + 7 < text.size() && text[i + 1] == 'f' && text[i + 2] == 'r' && text[i + 3] == 'a' && text[i + 4] == 's' && text[i + 5] == 'l' && text[i + 6] == ';') {
                    s += '/';
                    i += 6;
                } else {
                    s += text[i];
                }
            } else {
                s += text[i];
            }
        }
        return s;
    }
};