class Solution:
    def fullBloomFlowers(self, flowers: List[List[int]], people: List[int]) -> List[int]:
        
        res = []
        for p in people:
            res.append(sum(p >= s and p <= e for s, e in flowers))
        return res