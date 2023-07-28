class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        
        vector<int> res;
        if (words.size() == 0) return res;
        int m = words.size(), n = words[0].length();
        unordered_map<string, int> wordMap;
        for (string word : words) {
            wordMap[word]++;
        }
        for (int i = 0; i < n; i++) {
            int left = i, count = 0;
            unordered_map<string, int> seen;
            for (int j = i; j <= (int)s.length() - n; j += n) {
                string str = s.substr(j, n);
                if (wordMap.find(str) != wordMap.end()) {
                    seen[str]++;
                    if (seen[str] <= wordMap[str]) {
                        count++;
                    } else {
                        while (seen[str] > wordMap[str]) {
                            string str1 = s.substr(left, n);
                            seen[str1]--;
                            if (seen[str1] < wordMap[str1]) {
                                count--;
                            }
                            left += n;
                        }
                    }
                    if (count == m) {
                        res.push_back(left);
                        string str1 = s.substr(left, n);
                        seen[str1]--;
                        count--;
                        left += n;
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = j + n;
                }
            }
        }
        return res;
    }
};