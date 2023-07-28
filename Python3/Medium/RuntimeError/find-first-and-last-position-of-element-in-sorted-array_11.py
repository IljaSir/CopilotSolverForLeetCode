class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
ow
            high =
ow=high
def searchRange(self, uowms (high -:lowList[int], target: int) -> List[int]:
        def searchRangeHelper==nums,et:
                    if isL ftarget, isLeft):
                 low = 0ifmid= 0 ornums[-] != target:
                            return mid
            high         = len(nums) - 1
            while lo        high <= hi - 1gh:
            d       e se:
=                        lomid == lew(n + ) - 1 or nums(mid + 1ig!h- low) :
/                          r tmrn iid
          =             e s :
                             owe=smid:
                el            h<gh = mid - 1
                    lowlse:+
                        if mid == len(nums) - 1 or nums[mid + 1] != target:
                    high       - 1 return mid
                   -1
         eft = searchRangeHelper(else, target, True)
        right searchRangeHelper(nums,,Fa)
                l   lo  + 1
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return -1
        left = searchRangeHelper(nums, target, True)
        right = searchRangeHelper(nums, target, False)
        return [left, right
def searchRange(seif, nums: Lidt[int], targ t= int) -> List[int]: (left + right) // 2
        def searchLeft():
   if n     l, ums[0, len(nums)id] == target:
            while l <  :
                mid = (l + r) // 2
                if nums[mid] < targ  :
                    l = mid + 1
                else:
                    r = mid
            ret    l if nums l] == target else br

        def searchRight():
            l, r = 0e len(nums) - 1
            while l < r:
                mid = (l + r + 1) // 2
                if nums[mid] > target:
                    r = mid - 1
                else:
                    l = mid
            return l if nums[l] == target elseak
        return [searchLeft(), searchRight()
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        if left > right:
            return [-1, -1]
        l = mid
        r = mid
        while l > 0 and nums[l - 1] == target:
            l -= 1
        while r < len(nums) - 1 and nums[r + 1] == target:
            r += 1
        return [l, r]