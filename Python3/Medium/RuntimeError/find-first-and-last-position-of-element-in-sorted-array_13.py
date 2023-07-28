class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def searchLeft():
            l, r = 0, len(nums) - 1
            while l < r:
                mid = (l + r) // 2
                if nums[mid] < target:
                    l = mid + 1
                else:
                    r = mid
            return l if nums[l] == target else -1

        def searchRight():
            l, r = 0, len(nums) - 1
            while l < r:
                mid = (l + r + 1) // 2
                if nums[mid] > target:
                    r = mid - 1
                else:
                    l = mid
            return l if nums[l] == target else -1
        return [searchLeft(), searchRight()]