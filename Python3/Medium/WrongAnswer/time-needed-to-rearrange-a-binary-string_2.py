class Solution:
    def secondsToRemoveOccurrences(self, s: str) -> int:
        
        # The key is to find the pattern.
        # The pattern is that every time, the number of '0' and '1' will be the same.
        # So, we can use a counter to count the number of '0' and '1'.
        # The number of seconds needed is the number of '0' and '1'.
        # Time complexity: O(n)
        # Space complexity: O(1)
        count = 0
        for c in s:
            if c == '0':
                count += 1
            else:
                count -= 1
        return abs(count)