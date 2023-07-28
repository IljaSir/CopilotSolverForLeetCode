class Solution:
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        
        def isPalindrome(word):
            return word == word[::-1]
        
        def findWord(word):
            l = 0
            r = len(word) - 1
            while l < r:
                if word[l] != word[r]:
                    return False
                l += 1
                r -= 1
            return True
        
        def findWord2(word):
            l = 0
            r = len(word) - 1
            while l < r:
                if word[l] != word[r]:
                    return word[l:r]
                l += 1
                r -= 1
            return ""
        
        def findWord3(word):
            l = 0
            r = len(word) - 1
            while l < r:
                if word[l] != word[r]:
                    return word[l+1:r+1]
                l += 1
                r -= 1
            return ""
        
        def findWord4(word):
            l = 0
            r = len(word) - 1
            while l < r:
                if word[l] != word[r]:
                    return word[l:r+1]
                l += 1
                r -= 1
            return ""
        
        def findWord5(word):
            l = 0
            r = len(word) - 1
            while l < r:
                if word[l] != word[r]:
                    return word[l+1:r]
                l += 1
                r -= 1
            return ""
        
        def findWord6(word):
            l = 0
            r = len(word) - 1
            while l < r:
                if word[l] != word[r]:
                    return word[l+1:r+1]
                l += 1
                r -= 1
            return ""
        
        res = []
        for i in range(len(words)):
            for j in range(len(words)):
                if i == j:
                    continue
                if isPalindrome(words[i] + words[j]):
                    res.append([i, j])
        return res