class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        # count the number of each character
        count = {}
        for char in s:
            if char in count:
                count[char] += 1
            else:
                count[char] = 1
        # get the number of pairs
        pairs = 0
        odd = False
        for char in count:
            if count[char] % 2 == 0:
                pairs += count[char] // 2
            else:
                pairs += count[char] // 2
                odd = True
        # if there is an odd, add 1
        if odd:
            pairs += 1
        return pairs