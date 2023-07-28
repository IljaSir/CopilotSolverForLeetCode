class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        
        vector<string> result;
        int arr[26][100] = {0};
        for (int i = 0; i < words.size(); ++i) {
            for (int j = 0; j < words[i].size(); ++j) {
                arr[words[i][j] - 'a'][i]++;
            }
        }
        for (int i = 0; i < 26; ++i) {
            int min = 100;
            for (int j = 0; j < words.size(); ++j) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
            for (int j = 0; j < min; ++j) {
                string s;
                s.push_back(i + 'a');
                result.push_back(s);
            }
        }
        return result;
    }
};