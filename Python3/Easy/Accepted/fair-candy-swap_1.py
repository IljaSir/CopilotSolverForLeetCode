class Solution:
    def fairCandySwap(self, aliceSizes: List[int], bobSizes: List[int]) -> List[int]:
        
        sum_a, sum_b = sum(aliceSizes), sum(bobSizes)
        diff = (sum_a - sum_b) // 2
        set_b = set(bobSizes)
        for a in aliceSizes:
            if a - diff in set_b:
                return [a, a - diff]