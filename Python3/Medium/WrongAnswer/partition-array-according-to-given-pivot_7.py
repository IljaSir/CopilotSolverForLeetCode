class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        
        # 1st solution: 1 loop
        # Time  complexity: O(n)
        # Space complexity: O(1)
        # i = 0
        # j = 0
        # k = len(nums) - 1
        # while j <= k:
        #     if nums[j] > pivot:
        #         nums[j], nums[k] = nums[k], nums[j]
        #         k -= 1
        #     elif nums[j] < pivot:
        #         nums[i], nums[j] = nums[j], nums[i]
        #         i += 1
        #         j += 1
        #     else:
        #         j += 1
        # return nums

        # 2nd solution: 2 loops
        # Time  complexity: O(n)
        # Space complexity: O(1)
        i = 0
        for j in range(len(nums)):
            if nums[j] < pivot:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1
        for j in range(len(nums) - 1, -1, -1):
            if nums[j] > pivot:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1
        return nums