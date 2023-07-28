class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        
        # Runtime: 56 ms, faster than 21.89% of Python3 online submissions for Count Binary Substrings.
        # Memory Usage: 14.5 MB, less than 5.13% of Python3 online submissions for Count Binary Substrings.
        # Time complexity: O(n)
        # Space complexity: O(n)
        # Result: Accepted
        # Solution 1: 
        # count = 0
        # if len(s) < 2:
        #     return 0
        # for i in range(1, len(s)):
        #     if s[i] != s[i-1]:
        #         count += 1
        #         for j in range(1, min(i, len(s)-i)):
        #             if s[i-j] == s[i-1] and s[i+j] == s[i]:
        #                 count += 1
        #             else:
        #                 break
        # return count
        # Runtime: 40 ms, faster than 73.98% of Python3 online submissions for Count Binary Substrings.
        # Memory Usage: 14.3 MB, less than 5.13% of Python3 online submissions for Count Binary Substrings.
        # Time complexity: O(n)
        # Space complexity: O(n)
        # Result: Accepted
        # Solution 2: 
        groups = [1]
        for i in range(1, len(s)):
            if s[i-1] != s[i]:
                groups.append(1)
            else:
                groups[-1] += 1
        return sum(min(a, b) for a, b in zip(groups, groups[1:]))