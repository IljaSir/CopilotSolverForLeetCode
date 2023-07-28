class Solution:
    def groupStrings(self, words: List[str]) -> List[int]:
        
        def getSet(word):
            return set([(ord(c) - ord(word[0])) % 26 for c in word])
        sets = [getSet(word) for word in words]
        n = len(sets)
        ans = 0
        for i in range(n):
            if sets[i] == None:
                continue
            ans += 1
            for j in range(i + 1, n):
                if sets[i] == sets[j]:
                    sets[j] = None
        return ans