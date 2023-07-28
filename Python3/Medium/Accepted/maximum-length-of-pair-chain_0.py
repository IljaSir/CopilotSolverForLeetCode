class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        
        pairs.sort(key=lambda x: x[1])
        count = 1
        last = pairs[0][1]
        for i in range(1, len(pairs)):
            if pairs[i][0] > last:
                count += 1
                last = pairs[i][1]
        return count