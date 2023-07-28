class Solution {
public:
    string arrangeWords(string text) {
        
        map<int, string> m;
        string result;
        int count = 0;
        for (int i = 0; i < text.size(); i++) {
            if (text[i] == ' ') {
                m[count].append(" ");
                count = 0;
            } else {
                if (count == 0 && text[i] >= 'a' && text[i] <= 'z') {
                    text[i] = text[i] - 32;
                }
                m[count].append(1, text[i]);
                count++;
            }
        }
        m[count].append(" ");
        for (auto& it : m) {
            result.append(it.second);
        }
        result.pop_back();
        return result;
    }
};