class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        
        nums.sort()
        n = len(nums)
        closest = float('inf')
        for i in range(n-2):
            j, k = i+1, n-1
            while j < k:
                s = nums[i] + nums[j] + nums[k]
                if abs(s - target) < abs(closest - target):
                    closest = s
                if s == target:
                    return s
                elif s < target:
                    j += 1
                else:
                    k -= 1
        return closest