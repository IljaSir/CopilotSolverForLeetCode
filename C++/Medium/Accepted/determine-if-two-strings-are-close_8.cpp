class Solution {
public:
    bool closeStrings(string word1, string word2) {
        
        if (word1.size() != word2.size()) return false;
        int arr1[26] = {0};
        int arr2[26] = {0};
        for (auto c : word1) arr1[c - 'a']++;
        for (auto c : word2) arr2[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if ((arr1[i] == 0) ^ (arr2[i] == 0)) return false;
        }
        sort(arr1, arr1 + 26);
        sort(arr2, arr2 + 26);
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
};