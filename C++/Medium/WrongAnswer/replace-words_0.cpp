class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        
        string str = "";
        for (int i = 0; i < sentence.size(); i++) {
            if (sentence[i] != ' ') {
                str += sentence[i];
            } else {
                for (int j = 0; j < dictionary.size(); j++) {
                    if (dictionary[j].size() <= str.size()) {
                        string temp = str.substr(0, dictionary[j].size());
                        if (temp == dictionary[j]) {
                            str = temp;
                            break;
                        }
                    }
                }
                sentence.replace(i - str.size(), str.size(), str);
                i -= str.size() - 1;
                str = "";
            }
        }
        for (int j = 0; j < dictionary.size(); j++) {
            if (dictionary[j].size() <= str.size()) {
                string temp = str.substr(0, dictionary[j].size());
                if (temp == dictionary[j]) {
                    str = temp;
                    break;
                }
            }
        }
        sentence.replace(sentence.size() - str.size(), str.size(), str);
        return sentence;
    }
};