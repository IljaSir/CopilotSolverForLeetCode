class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        
        if k == 0:
            return any(nums[i] == 0 and nums[i+1] == 0 for i in range(len(nums)-1))
        if k < 0:
            k = -k
        n = len(nums)
        if n < 2:
            return False
        presum = [0]
        for i in range(n):
            presum.append((presum[-1] + nums[i]) % k)
        for i in range(n-1):
            for j in range(i+2, n+1):
                if presum[j] == presum[i]:
                    return True
        return False