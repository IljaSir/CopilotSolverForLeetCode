class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        
        def isPalindrome(word):
            return word[0] == word[1]
        def isReversePalindrome(word):
            return word[0] == word[1][::-1]
        def getReverse(word):
            return word[1][::-1]
        def getLength(word):
            return len(word[0])
        def getLengthReverse(word):
            return len(word[1][::-1])
        def getLengthSum(word):
            return len(word[0]) + len(word[1][::-1])
        def getLengthSumReverse(word):
            return len(word[1][::-1]) + len(word[0])
        def getLengthSum2(word):
            return len(word[0]) + len(word[1])
        def getLengthSumReverse2(word):
            return len(word[1]) + len(word[0])
        def getLengthSum3(word):
            return len(word[0]) + len(word[1])
        def getLengthSumReverse3(word):
            return len(word[1]) + len(word[0])
        def getLengthSum4(word):
            return len(word[0]) + len(word[1])
        def getLengthSumReverse4(word):
            return len(word[1]) + len(word[0])
        def getLengthSum5(word):
            return len(word[0]) + len(word[1])
        def getLengthSumReverse5(word):
            return len(word[1]) + len(word[0])
        def getLengthSum6(word):
            return len(word[0]) + len(word[1])
        def getLengthSumReverse6(word):
            return len(word[1]) + len(word[0])
        def getLengthSum7(word):
            return len(word[0]) + len(word[1])
        def getLengthSumReverse7(word):
            return len(word[1]) + len(word[0])
        def getLengthSum8(word):
            return len(word[0]) + len(word[1])
        def getLengthSumReverse8(word):
            return len(word[1]) + len(word[0])
        def getLengthSum9(word):
            return len(word[0]) + len(word[1])
        def getLengthSumReverse9(word):
            return len(word[1]) + len(word[0])
        def getLengthSum10(word):
            return len(word[0]) + len(word[1])
        def getLength% 2 == 0:
                count += value
            else:
                count += value - 1
                odd = True
        if odd:
            count += 1
        return count