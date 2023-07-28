class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        
        def count(word):
            ans = [0]*26
            for letter in word:
                ans[ord(letter) - ord('a')] += 1
            return ans

        target = [0]*26
        for word in words2:
            for i, c in enumerate(count(word)):
                target[i] = max(target[i], c)

        ans = []
        for word in words1:
            if all(x >= y for x, y in zip(count(word), target)):
                ans.append(word)
        return ans