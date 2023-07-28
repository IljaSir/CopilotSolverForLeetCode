class Solution:
    def fairCandySwap(self, aliceSizes: List[int], bobSizes: List[int]) -> List[int]:
        
        sum_alice = sum(aliceSizes)
        sum_bob = sum(bobSizes)
        for candy_alice in aliceSizes:
            for candy_bob in bobSizes:
                if candy_alice - candy_bob == (sum_alice - sum_bob) / 2:
                    return [candy_alice, candy_bob]