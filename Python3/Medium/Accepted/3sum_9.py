class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        
        # 1. sort
        # 2. use two pointers
        # 3. skip duplicates
        # 4. skip if sum > 0
        # 5. skip if sum < 0
        # 6. skip if sum == 0
        # 7. return
        if len(nums) < 3:
            return []
        nums.sort()
        res = []
        for i in range(len(nums) - 2):
            if i == 0 or (i > 0 and nums[i] != nums[i - 1]):
                lo = i + 1
                hi = len(nums) - 1
                sum = 0 - nums[i]
                while lo < hi:
                    if nums[lo] + nums[hi] == sum:
                        res.append([nums[i], nums[lo], nums[hi]])
                        while lo < hi and nums[lo] == nums[lo + 1]:
                            lo += 1
                        while lo < hi and nums[hi] == nums[hi - 1]:
                            hi -= 1
                        lo += 1
                        hi -= 1
                    elif nums[lo] + nums[hi] < sum:
                        lo += 1
                    else:
                        hi -= 1
        return res