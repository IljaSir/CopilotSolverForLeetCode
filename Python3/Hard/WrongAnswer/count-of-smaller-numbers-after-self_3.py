class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        if n == 0: return []
        if n == 1: return [0]
        mid = n // 2
        left = self.countSmaller(nums[:mid])
        right = self.countSmaller(nums[mid:])
        res = [0] * n
        i = j = 0
        while i < len(left) and j < len(right):
            if nums[mid + i] < nums[j]:
                res[i + j] += left[i] + 1
                i += 1
            else:
                res[i + j] += right[j]
                j += 1
        while i < len(left):
            res[i + j] += left[i]
            i += 1
        while j < len(right):
            res[i + j] += right[j]
            j += 1
        return res