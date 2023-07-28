class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        
        def merge(nums, l, m, r):
            i = j = 0
            res = 0
            while i < len(l) or j < len(r):
                if j == len(r) or (i < len(l) and l[i] <= r[j]):
                    nums[i+j] = l[i]
                    i += 1
                else:
                    nums[i+j] = r[j]
                    j += 1
                    res += len(l) - i
            return res

        def merge_sort(nums):
            if len(nums) <= 1:
                return 0
            m = len(nums) // 2
            l = nums[:m]
            r = nums[m:]
            res = merge_sort(l) + merge_sort(r)
            res += merge(nums, l, r)
            return res

        return merge_sort(nums)