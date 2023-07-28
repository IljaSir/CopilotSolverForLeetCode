class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        # print("s:", s)
        # print("len(s):", len(s))
        if len(s) == 1:
            return 1
        if len(s) == 2:
            if s[0] == s[1]:
                return 2
            else:
                return 1
        if len(s) == 3:
            if s[0] == s[1] or s[0] == s[2] or s[1] == s[2]:
                return 3
            else:
                return 1
        # print("s:", s)
        # print("len(s):", len(s))
        # print("len(s)/2:", len(s)/2)
        # print("len(s)/2+1:", len(s)/2+1)
        # print("int(len(s)/2):", int(len(s)/2))
        # print("int(len(s)/2+1):", int(len(s)/2+1))
        # print("s[int(len(s)/2):int(len(s)/2+1)]