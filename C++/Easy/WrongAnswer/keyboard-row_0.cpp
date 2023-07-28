class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        
        vector<string> row1 = {"q","w","e","r","t","y","u","i","o","p"};
        vector<string> row2 = {"a","s","d","f","g","h","j","k","l"};
        vector<string> row3 = {"z","x","c","v","b","n","m"};
        vector<string> result;
        for (int i = 0; i < words.size(); i++) {
            string word = words[i];
            vector<string> row;
            if (find(row1.begin(), row1.end(), word.substr(0,1)) != row1.end()) {
                row = row1;
            } else if (find(row2.begin(), row2.end(), word.substr(0,1)) != row2.end()) {
                row = row2;
            } else if (find(row3.begin(), row3.end(), word.substr(0,1)) != row3.end()) {
                row = row3;
            }
            bool flag = true;
            for (int j = 1; j < word.length(); j++) {
                if (find(row.begin(), row.end(), word.substr(j,1)) == row.end()) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                result.push_back(word);
            }
        }
        return result;
    }
};