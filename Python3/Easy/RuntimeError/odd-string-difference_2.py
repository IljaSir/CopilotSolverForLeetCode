class Solution:
    def oddString(self, words: List[str]) -> str:
        
        n = len(words[0])
        for word in words:
            diff = []
            for i in range(1, n):
                diff.append(ord(word[i]) - ord(word[i - 1]))
            if diff not in diffs:
                diffs.append(diff)
            else:
                diffs.remove(diff)
        for word in words:
            diff = []
            for i in range(1, n):
                diff.append(ord(word[i]) - ord(word[i - 1]))
            if diff == diffs[0]:
                return word