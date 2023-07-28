class Solution:
    def fairCandySwap(self, aliceSizes: List[int], bobSizes: List[int]) -> List[int]:
        
        sum_alice = sum(aliceSizes)
        sum_bob = sum(bobSizes)
        diff = (sum_alice - sum_bob) // 2
        set_bob = set(bobSizes)
        for candy in aliceSizes:
            if candy - diff in set_bob:
                return [candy, candy - diff]