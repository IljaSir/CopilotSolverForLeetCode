class Solution:
    def similarPairs(self, words: List[str]) -> int:
        
        def isSimilar(a, b):
            if len(a) != len(b):
                return False
            diff_count = 0
            for i in range(len(a)):
                if a[i] != b[i]:
                    diff_count += 1
                    if diff_count > 2:
                        return False
            return True
        pairs = 0
        for i in range(len(words)):
            for j in range(i+1, len(words)):
                if isSimilar(words[i], words[j]):
                    pairs += 1
        return pairs