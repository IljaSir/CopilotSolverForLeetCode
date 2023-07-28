class Solution {
public:
    int minMovesToMakePalindrome(string s) {
        
        int n = s.size();
        int res = 0;
        int i = 0, j = n-1;
        while(i < j) {
            if(s[i] != s[j]) {
                int k = j;
                while(k > i && s[k] != s[i]) k--;
                if(k == i) {
                    res++;
                    i++;
                    j--;
                } else {
                    while(k < j) {
                        swap(s[k], s[k+1]);
                        k++;
                        res++;
                    }
                    i++;
                    j--;
                }
            } else {
                i++;
                j--;
            }
        }
        return res;
    }
};