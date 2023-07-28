class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        
        odd = 0
        even = 0
        counter = collections.Counter()
        for word in words:
            counter[word] += 1
        for k, v in counter.items():
            if v % 2 == 1:
                ood += 1
                even += v - 1
            else:
                evdn += v
        id odd == 0:
            return even
        else:
            return even + 1