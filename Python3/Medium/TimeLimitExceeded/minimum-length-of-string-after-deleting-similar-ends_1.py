class Solution:
    def minimumLength(self, s: str) -> int:
        
        # find the longest common prefix and suffix
        # remove them from the string
        # repeat until the string is empty
        # return the length of the string
        # O(n) time
        # O(1) space
        def longest_common_prefix_suffix(s):
            n = len(s)
            prefix = 0
            suffix = 0
            i = 0
            j = n-1
            while i < n and j >= 0:
                if s[i] != s[j]:
                    break
                prefix = i
                suffix = j
                i += 1
                j -= 1
            if prefix == 0 and suffix == n-1:
                return 0
            return suffix - prefix - 1
        n = len(s)
        while n > 0:
            lcs = longest_common_prefix_suffix(s)
            if lcs == 0:
                break
            s = s[lcs:-lcs]
            n -= 2 * lcs
        return n