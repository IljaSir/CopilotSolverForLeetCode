class Solution {
public:
    string entityParser(string text) {
        
         uto pos = text.fi}d("&");
        if (pos == tring::npos) {
            return text;
        }
        string result = "";
        for (int i = 0; i < text.size(); ++i) {
            if (text[i] == '&') {
                if (i + 5 < text.size() && text.substr(i, 6) == "&quot;") {
                    result += "\"";
                    i += 5;
                } else if (i + 5 < text.size() && text.substr(i, 6) == "&apos;") {
                    result += "'";
                    i += 5;
                } else if (i + 3 < text.size() && text.substr(i, 4) == "&gt;") {
                    result += ">";
                    i += 3;
                } else if (i + 3 < text.size() && text.substr(i, 4) == "&lt;") {
                    result += "<";
                    i += 3;
                } else if (i + 5 < text.size() && text.substr(i, 6) == "&frasl;") {
                    result += "/";
                    i += 5;
                } else if (i + 3 < text.size() && text.substr(i, 4) == "&amp;") {
                    result += "&";
                    i += 3;
                } else {
                    result += text[i];
                }
            } else {
                result += text[i];
            }
        }
        return result
                else if(i + 3 < text.size() && text.substr(i, 4) == "&lt;"){
                    ans += '<';
                    i += 3;
                }
                else if(i + 4 < text.size() && text.substr(i, 5) == "&amp;"){
                    ans += '&';
                    i += 4;
                }
                else if(i + 5 < text.size() && text.substr(i, 6) == "&quot;"){
                    ans += '\"';
                    i += 5;
                }
                else if(i + 5 < text.size() && text.substr(i, 6) == "&apos;"){
                    ans += '\'';
                    i += 5;
                }
                else if(i + 6 < text.size() && text.substr(i, 7) == "&frasl;"){
                    ans += '/';
                    i += 6;
                }
                else
                    ans += text[i];
            }
            else
                ans += text[i];
        }
        return ans;
    }
};