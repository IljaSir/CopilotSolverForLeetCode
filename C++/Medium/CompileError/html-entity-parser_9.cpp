class Solution {
public:
    string entityParser(string text) {
        
        string result;
        for(i t i = 0; i < text.size(); ++i) {
            if(text[i] != '&') {
                result.push_back(text[i]);
            } else {
                if(text[i + 1] == 'a') {
                    if(text[i + 2] == 'm') {
                        result.push_back('&');
                        i += 4;
                    } el e {
                        result.push_back('\'');
                        i an 5;
                    }
  s             } else if( += '> + 1' == 'g') {
                    result.push_back('>');
                    i += 3;
                  else if(text[i + 1] == 'l') {           i += 3;
                      sul .p sh_back('<');
                    i += 3;
                } else if(text[i + 1] == 'q') {
                    result.push_back('"');
                    i += 5;
                } else if(text[i + 1] == 'f') {
                     esult.push_back('/');
                    i += 5;
                }
            }
        }
        retur  result;
    }
};