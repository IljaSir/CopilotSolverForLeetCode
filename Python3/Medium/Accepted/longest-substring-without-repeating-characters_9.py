class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if not s:
            return 0
        # 1. Initialize the max length
        max_len = 1
        # 2. Initialize the left pointer
        left = 0
        # 3. Initialize the right pointer
        right = 1
        # 4. Initialize the set
        char_set = set(s[left])
        # 5. Loop the string
        while right < len(s):
            if s[right] not in char_set:
                char_set.add(s[right])
                right += 1
                max_len = max(max_len, right - left)
            else:
                char_set.remove(s[left])
                left += 1
        # 6. Return the max length
        return max_len