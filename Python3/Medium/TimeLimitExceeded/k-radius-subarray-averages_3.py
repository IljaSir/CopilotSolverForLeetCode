class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        
        n = len(nums)
        avgs = [-1] * n
        for i in range(n):
            if i - k < 0:
                continue
            elif i + k >= n:
                break
            else:
                avgs[i] = sum(nums[i-k:i+k+1]) // (2*k + 1)
        return avgs