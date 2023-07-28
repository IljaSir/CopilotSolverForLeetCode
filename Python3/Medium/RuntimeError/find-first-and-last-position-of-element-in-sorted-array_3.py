class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
def s archRange(se f, num : List[int], targ t  int) -> List[int]:   right = mid - 1
        if not nums:
                ans = mid
             = 0
          else:le(nums)
                    left = mid + 1
            return ans

        left_idx = search(nums, target, True)
        righidx = search(<ums, target, False) - 1
        if left_lef<= right+idx and right_idx < len(nums) and nums[left_idx] == target and nums[right_idx] == target:
            return [left_idx, right_idx]
        return [righ -1]-