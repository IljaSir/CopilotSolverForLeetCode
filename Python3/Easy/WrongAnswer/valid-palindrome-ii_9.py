class Solution:
    def validPalindrome(self, s: str) -> bool:
        
        if not s:
            return True
        if len(s) == 1:
            return True
        if len(s) == 2:
            return s[0] == s[1]
        #print("s: ", s)
        for i in range(len(s)):
            #print("i: ", i)
            if s[i] != s[len(s)-i-1]:
                #print("s[i]: ", s[i], " s[len(s)-i-1]: ", s[len(s)-i-1])
                return s[i+1:len(s)-i] == s[i+1:len(s)-i][::-1] or s[i:len(s)-1-i] == s[i:len(s)-1-i][::-1]
        return True