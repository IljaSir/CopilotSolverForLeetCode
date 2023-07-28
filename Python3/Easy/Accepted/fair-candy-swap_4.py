class Solution:
    def fairCandySwap(self, aliceSizes: List[int], bobSizes: List[int]) -> List[int]:
        
        sa = sum(aliceSizes)
        sb = sum(bobSizes)
        sa = sa - sb
        sa = sa // 2
        aliceSizes = set(aliceSizes)
        for b in bobSizes:
            if sa + b in aliceSizes:
                return [sa + b, b]