class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        # left = 0
        # right = 0
        # max_len = 0
        # count = 0
        # while right < len(s):
        #     if s[right] in s[left:right]:
        #         max_len = max(max_len, count)
        #         left += 1
        #         right = left
        #         count = 0
        #     else:
        #         right += 1
        #         count += 1
        # return max(max_len, count)
        left = 0
        right = 0
        max_len = 0
        count = 0
        while right < len(s):
            if s[right] in s[left:right]:
                max_len = max(max_len, count)
                left += 1
                right = left
                count = 0
            else:
                right += 1
                count += 1
        return max(max_len, count)