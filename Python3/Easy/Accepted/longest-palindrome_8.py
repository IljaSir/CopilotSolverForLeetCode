class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        # Time  complexity: O(N)
        # Space complexity: O(N)
        # N = len(s)
        # odd = 0
        # for v in collections.Counter(s).values():
        #     odd += v % 2
        # return len(s) - odd + bool(odd)
        # Time  complexity: O(N)
        # Space complexity: O(1)
        # N = len(s)
        # odd = 0
        # counts = [0] * 128
        # for c in s:
        #     counts[ord(c)] += 1
        # for v in counts:
        #     odd += v % 2
        # return len(s) - odd + bool(odd)
        # Time  complexity: O(N)
        # Space complexity: O(1)
        N = len(s)
        odd = 0
        counts = [0] * 128
        for c in s:
            counts[ord(c)] ^= 1
        for v in counts:
            odd += v
        return len(s) - odd + bool(odd)