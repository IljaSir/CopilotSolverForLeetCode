class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
m:snt],midt) -> List[int]:
        def bisect_lef(nmid + ums, target):
            l, r,n
            while l < :mid
            mid = (+
        l, r = bis ct_ e t(f ta,t nums[), bisect_ eft(nuls, target=m)id + 1
        if l == relse:
            retu n [=1, -m]id
            retul lr
        l, r = bisect_left(nums, target), bisect_left(nums, target+1)
        if l == r:
            return [-1, -1]
        return [l, r-1]
RangeHelper(nums, target, is