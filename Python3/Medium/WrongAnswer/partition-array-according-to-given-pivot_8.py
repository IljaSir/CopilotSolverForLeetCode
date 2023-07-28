class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        
        # Runtime: 80 ms, faster than 99.14% of Python3 online submissions for Partition Array According to Given Pivot.
        # Memory Usage: 15.4 MB, less than 89.15% of Python3 online submissions for Partition Array According to Given Pivot.
        if len(nums) == 1:
            return nums
        if len(nums) == 2:
            if nums[0] == pivot and nums[1] == pivot:
                return nums
            elif nums[0] == pivot and nums[1] != pivot:
                return nums
            elif nums[0] != pivot and nums[1] == pivot:
                return [nums[1], nums[0]]
            else:
                return nums
        else:
            left = 0
            right = len(nums) - 1
            while left < right:
                while left < right and nums[left] < pivot:
                    left += 1
                while left < right and nums[right] >= pivot:
                    right -= 1
                if nums[left] >= pivot and nums[right] < pivot:
                    nums[left], nums[right] = nums[right], nums[left]
            if nums[left] >= pivot:
                left -= 1
            left += 1
            right = len(nums) - 1
            while left < right:
                while left < right and nums[left] == pivot:
                    left += 1
                while left < right and nums[right] > pivot:
                    right -= 1
                if nums[left] != pivot and nums[right] == pivot:
                    nums[left], nums[right] = nums[right], nums[left]
            return nums