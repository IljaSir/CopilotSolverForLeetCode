class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        n = len(nums)
        if n == 0:
            return [-1, -1]
        if n == 1:
            if nums[0] == target:
                return [0, 0]
            else:
                return [-1, -1]
        left, right = 0, n - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                break
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        if left > right:
            return [-1, -1]
        else:
            start, end = mid, mid
            while start > 0:
                if nums[start - 1] == target:
                    start -= 1
                else:
                    break
            while end < n - 1:
                if nums[end + 1] == target:
                    end += 1
                else:
                    break
            return [start, end]