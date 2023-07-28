class Solution {
public:
    string entityParser(string text) {
        
        auto pos = text.find("&");
        if (pos == string::npos) {
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
        return result;
    }
};