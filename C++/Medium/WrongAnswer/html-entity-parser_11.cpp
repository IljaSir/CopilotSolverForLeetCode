class Solution {
public:
    string entityParser(string text) {
        
        string result;
        for(int i = 0; i < text.size(); ++i) {
            if(text[i] != '&') {
                result.push_back(text[i]);
            } else {
                if(text[i + 1] == 'a') {
                    if(text[i + 2] == 'm') {
                        result.push_back('&');
                        i += 4;
                    } else {
                        result.push_back('\'');
                        i += 5;
                    }
                } else if(text[i + 1] == 'g') {
                    result.push_back('>');
                    i += 3;
                } else if(text[i + 1] == 'l') {
                    result.push_back('<');
                    i += 3;
                } else if(text[i + 1] == 'q') {
                    result.push_back('"');
                    i += 5;
                } else if(text[i + 1] == 'f') {
                    result.push_back('/');
                    i += 5;
                }
            }
        }
        return result;
    }
};