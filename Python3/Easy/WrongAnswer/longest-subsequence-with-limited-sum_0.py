class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        
        nums.sort()
        res = []
        for q in queries:
            left = 0
            right = len(nums) - 1
            while left <= right:
                mid = left + (right - left) // 2
                if nums[mid] <= q:
                    left = mid + 1
                else:
                    right = mid - 1
            res.append(left)
        return res