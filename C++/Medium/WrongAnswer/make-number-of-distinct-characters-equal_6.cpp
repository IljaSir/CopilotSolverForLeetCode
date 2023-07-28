class Solution {
public:
    bool isItPossible(string word1, string word2) {
        
        int n = word1.size();
        int m = word2.size();
        int i = 0, j = 0;
        int count = 0;
        while(i < n && j < m) {
            if(word1[i] != word2[j]) {
                count++;
            }
            i++;
            j++;
        }
        if(count > 2) {
            return false;
        }
        return true;
    }
    bool areDistinct(string word1, string word2) {
        int n = word1.size();
        int m = word2.size();
        int i = 0, j = 0;
        int count = 0;
        unordered_map<char, int> mp;
        while(i < n && j < m) {
            if(word1[i] != word2[j]) {
                mp[word1[i]]++;
                mp[word2[j]]++;
            }
            i++;
            j++;
        }
        for(auto x: mp) {
            if(x.second > 1) {
                return false;
            }
        }
        return true;
    }
    bool areSame(string word1, string word2) {
        int n = word1.size();
        int m = word2.size();
        int i = 0, j = 0;
        int count = 0;
        while(i < n && j < m) {
            if(word1[i] != word2[j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
    bool areSameDistinct(string word1, string word2) {
        int n = word1.size();
        int m = word2.size();
        int i = 0, j = 0;
        int count = 0;
        unordered_map<char, int> mp;
        while(i < n && j < m) {
            if(word1[i] != word2[j]) {
                mp[word1[i]]++;
                mp[word2[j]]++;
            }
            i++;
            j++;
        }
        for(auto x: mp) {
            if(x.second > 1) {
                return false;
            }
        }
        return true;
    }
};