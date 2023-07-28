class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        
        # merge sort
        def merge_sort(l, r):
            if l >= r:
                return
            m = l + (r-l)//2
            merge_sort(l, m)
            merge_sort(m+1, r)
            merge(l, m, r)
        def merge(l, m, r):
            i, j = l, m + 1
            while i <= m and j <= r:
                if nums[i] > nums[j]:
                    count[nums[i]] += r - j + 1
                    i += 1
                else:
                    j += 1
            nums[l:r+1] = sorted(nums[l:r+1])
        n = len(nums)
        count = collections.Counter()
        merge_sort(0, n-1)
        return [count[num] for num in nums]