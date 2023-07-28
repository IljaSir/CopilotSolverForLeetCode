class Solution:
    def longestContinuousSubstring(self, s: str) -> int:
        
        # Solution 1: self
        # n = len(s)
        # if n == 1:
        #     return 1
        # max_len = 1
        # cur_len = 1
        # for i in range(1, n):
        #     if ord(s[i]) - ord(s[i-1]) == 1:
        #         cur_len += 1
        #         max_len = max(max_len, cur_len)
        #     else:
        #         cur_len = 1
        # return max_len

        # Solution 2: self
        n = len(s)
        if n == 1:
            return 1
        max_len = 1
        cur_len = 1
        for i in range(1, n):
            if ord(s[i]) - ord(s[i-1]) == 1:
                cur_len += 1
            else:
                cur_len = 1
            max_len = max(max_len, cur_len)
        return max_len

        # Solution 3: self
        # n = len(s)
        # if n == 1:
        #     return 1
        # max_len = 1
        # cur_len = 1
        # for i in range(1, n):
        #     if ord(s[i]) - ord(s[i-1]) == 1:
        #         cur_len += 1
        #     else:
        #         cur_len = 1
        #     max_len = max(max_len, cur_len)
        # return max_len

        # Solution 4: self
        # n = len(s)
        # if n == 1:
        #     return 1
        # max_len = 1
        # cur_len = 1
        # for i in range(1, n):
        #     if ord(s[i]) - ord(s[i-1]) == 1:
        #         cur_len += 1
        #     else:
        #         cur_len = 1
        #     max_len = max(max_len, cur_len)
        # return max_len

        # Solution 5: self
        # n = len(s)
        # if n == 1:
        #     return 1
        # max_len = 1
        # cur_len = 1