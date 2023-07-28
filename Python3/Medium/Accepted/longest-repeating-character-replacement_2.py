class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        if len(s) == 1:
            return 1
        left = 0
        right = 0
        max_len = 0
        max_char = 0
        count = [0] * 26
        while right < len(s):
            count[ord(s[right]) - ord('A')] += 1
            max_char = max(max_char, count[ord(s[right]) - ord('A')])
            while right - left + 1 - max_char > k:
                count[ord(s[left]) - ord('A')] -= 1
                left += 1
            max_len = max(max_len, right - left + 1)
            right += 1
        return max_len