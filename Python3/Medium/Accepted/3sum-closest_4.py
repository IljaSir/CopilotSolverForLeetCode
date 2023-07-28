class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        
        nums.sort()
        n = len(nums)
        ans = sum(nums[:3])
        for i in range(n-2):
            j, k = i+1, n-1
            while j < k:
                s = nums[i] + nums[j] + nums[k]
                if abs(s-target) < abs(ans-target):
                    ans = s
                if s > target:
                    k -= 1
                elif s < target:
                    j += 1
                else:
                    return ans
        return ans