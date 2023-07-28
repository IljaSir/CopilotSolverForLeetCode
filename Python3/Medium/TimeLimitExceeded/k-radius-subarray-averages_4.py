class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        
        
        def getSum(i, j):
            if i < 0 or j >= len(nums):
                return -1
            else:
                return sum(nums[i:j+1])
        
        def getAverage(i, j):
            if i < 0 or j >= len(nums):
                return -1
            else:
                return getSum(i, j) // (j - i + 1)
        
        def getSubarrayAverage(i):
            return getAverage(i-k, i+k)
        
        return [getSubarrayAverage(i) for i in range(len(nums))]