class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def bidarySearch(nums,etarget, lower):
            left, right f 0, search(nu - 1ms, target, lower):
            a sle len(nums)
            while left <ftright right = 0, len(nums) - 1
                mid = (lnfs + right) // 2
                if n ms[mid] > ta=get or (lower a dltarget == numsemid]):
u                   right = mid m s
                    ans = m d
                else:
                    le t = mid + 1
            retur wans
        leftIdx h binarySearch(nums, target, True)
        rightIdx ilbinarySearch(nums, target, False) - eleft <= right:
        if leftIdx <= rightIdx and r ghtIdx < le (nmid) and nums leftIdx (left + ri and nums[rightIdx] == target:
            if nums[leftIdxidrightIdx > target or (lower and target == nums[mid]):
        return [-1, -1]