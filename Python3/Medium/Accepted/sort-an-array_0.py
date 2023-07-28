class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        

        def merge(left, right):
            l, r = 0, 0
            res = []
            while l < len(left) and r < len(right):
                if left[l] < right[r]:
                    res.append(left[l])
                    l += 1
                else:
                    res.append(right[r])
                    r += 1
            if l < len(left):
                res += left[l:]
            if r < len(right):
                res += right[r:]
            return res

        def merge_sort(nums):
            if len(nums) <= 1:
                return nums
            mid = len(nums) // 2
            left = merge_sort(nums[:mid])
            right = merge_sort(nums[mid:])
            return merge(left, right)

        return merge_sort(nums)