class Solution {
public:
    string firstPalindrome(vector<string>& words) {
        
        for(auto& word: words){
            if(isPalindrome(word)) return word;
        }
        return "";
    }
    bool isPalindrome(string& s){
        int lo = 0, hi = s.size() - 1;
        while(lo < hi){
            if(s[lo++] != s[hi--]) return false;
        }
        return true;
    }
};