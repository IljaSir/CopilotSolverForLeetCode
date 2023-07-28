class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        
        query = [0] * (len(words) + 1)
        for i in range(len(words)):
            if words[i][0] in ['a', 'e', 'i', 'o', 'u'] and words[i][-1] in ['a', 'e', 'i', 'o', 'u']:
                query[i + 1] = 1
        for i in range(1, len(query)):
            query[i] += query[i - 1]
        ans = []
        for l, r in queries:
            ans.append(query[r + 1] - query[l])
        return ans