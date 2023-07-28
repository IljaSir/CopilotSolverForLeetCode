class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        
        if not nums:
            return 0
        sums = [0]
        for num in nums:
            sums.append(sums[-1] + num)
        def merge_sort(sums, l, r):
            if l >= r:
                return 0
            m = (l + r) // 2
            res = merge_sort(sums, l, m) + merge_sort(sums, m+1, r)
            i, j, k = l, m+1, m+1
            for left in sums[l:m+1]:
                while k <= r and sums[k] - left < lower:
                    k += 1
                while j <= r and sums[j] - left <= upper:
                    j += 1
                res += j - k
            sums[l:r+1] = sorted(sums[l:r+1])
            return res
        return merge_sort(sums, 0, len(sums)-1)