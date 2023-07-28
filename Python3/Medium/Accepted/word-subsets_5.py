class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        
        def get_count(s):
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            return count

        count2 = [0] * 26
        for w in words2:
            count = get_count(w)
            for i in range(26):
                count2[i] = max(count2[i], count[i])

        res = []
        for w in words1:
            count = get_count(w)
            if all(count[i] >= count2[i] for i in range(26)):
                res.append(w)
        return res