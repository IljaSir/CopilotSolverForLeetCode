class Solution:
    def fairCandySwap(self, aliceSizes: List[int], bobSizes: List[int]) -> List[int]:
        
        alice = sum(aliceSizes)
        bob = sum(bobSizes)
        aliceSet = set(aliceSizes)
        bobSet = set(bobSizes)
        for i in aliceSet:
            if i + (bob - alice) // 2 in bobSet:
                return [i, i + (bob - alice) // 2]