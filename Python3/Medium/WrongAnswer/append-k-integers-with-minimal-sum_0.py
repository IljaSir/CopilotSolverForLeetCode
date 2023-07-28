class Solution:
    def minimalKSum(self, nums: List[int], k: int) -> int:
        
        nums.sort()
        ans = 0
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            if nums[i] > ans + 1:
                if k > 0:
                    ans += 1
                    k -= 1
                else:
                    break
            ans += nums[i]
        return ans + k