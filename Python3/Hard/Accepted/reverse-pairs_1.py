class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        
        def merge_sort(l, r):
            if l >= r:
                return 0
            mid = (l + r) // 2
            res = merge_sort(l, mid) + merge_sort(mid + 1, r)
            i = l
            for j in range(mid + 1, r + 1):
                while i <= mid and nums[i] <= 2 * nums[j]:
                    i += 1
                res += mid - i + 1
            nums[l:r + 1] = sorted(nums[l:r + 1])
            return res
        return merge_sort(0, len(nums) - 1)