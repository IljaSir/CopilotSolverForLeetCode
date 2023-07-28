class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        
        nums.sort()
        ans = 0
        diff = 10000
        for i in range(len(nums)):
            j = i + 1
            k = len(nums) - 1
            while j < k:
                sum = nums[i] + nums[j] + nums[k]
                if sum == target:
                    return target
                else:
                    if abs(sum - target) < diff:
                        ans = sum
                        diff = abs(sum - target)
                    if sum > target:
                        k -= 1
                    else:
                        j += 1
        return ans