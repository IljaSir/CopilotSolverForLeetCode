class Solution {
public:
    int similarPairs(vector<string>& words) {
        
        int n = words.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[i].length() == words[j].length()) {
                    int arr[26] = {0};
                    bool flag = true;
                    for (int k = 0; k < words[i].length(); k++) {
                        arr[words[i][k] - 'a']++;
                        arr[words[j][k] - 'a']--;
                    }
                    for (int k = 0; k < 26; k++) {
                        if (arr[k] != 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
};