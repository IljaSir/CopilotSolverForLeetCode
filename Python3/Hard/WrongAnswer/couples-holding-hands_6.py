class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        
        n = len(row) // 2
        pairs = {}
        for i in range(n):
            pairs[row[2*i]] = row[2*i+1]
            pairs[row[2*i+1]] = row[2*i]
        swaps = 0
        seen = set()
        for i in range(n):
            if row[2*i] not in seen:
                seen.add(row[2*i])
                seen.add(pairs[row[2*i]])
                j = pairs[row[2*i]]
                while j != row[2*i]:
                    seen.add(j)
                    seen.add(pairs[j])
                    j = pairs[j]
                    swaps += 1
        return swaps