class Solution {
public:
    bool isPalindrome(string s) {
        
        int n = s.size();
        if(n == 0) return true;
        int i = 0, j = n-1;
        while(i < j){
            while(i < j && !isalnum(s[i])) i++;
            while(i < j && !isalnum(s[j])) j--;
            if(tolower(s[i]) != tolower(s[j])) return false;
            i++;
            j--;
        }
        return true;
    }
};