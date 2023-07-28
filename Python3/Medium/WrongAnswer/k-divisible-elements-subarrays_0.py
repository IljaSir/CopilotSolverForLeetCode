class Solution:
    def countDistinct(self, nums: List[int], k: int, p: int) -> int:
        
        count = 0
        for i in range(len(nums)):
            for j in range(i, min(i + k, len(nums))):
                if sum(nums[i:j+1]) % p == 0:
                    count += 1
        return count