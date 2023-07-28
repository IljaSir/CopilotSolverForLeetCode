class Solution:
    def countExcellentPairs(self, nums: List[int], k: int) -> int:
        
        def countSetBits(x):
            count = 0
            while x > 0:
                count += x & 1
                x >>= 1
            return count
        
        def countSetBitsInORandAND(x, y):
            return countSetBits(x | y) + countSetBits(x & y)
        
        def countPairsWithSumAtLeastK(nums, k):
            count = 0
            for i in range(len(nums)):
                for j in range(i + 1, len(nums)):
                    if countSetBitsInORandAND(nums[i], nums[j]) >= k:
                        count += 1
            return count
        
        return countPairsWithSumAtLeastK(nums, k)