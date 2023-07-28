class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        
        def merge_sort(arr):
            if len(arr) <= 1:
                return arr
            mid = len(arr) // 2
            left = merge_sort(arr[:mid])
            right = merge_sort(arr[mid:])
            return merge(left, right)
        
        def merge(left, right):
            i, j = 0, 0
            res = []
            while i < len(left) and j < len(right):
                if left[i] <= right[j]:
                    res.append(left[i])
                    i += 1
                else:
                    res.append(right[j])
                    j += 1
            res += left[i:]
            res += right[j:]
            return res
        
        arr = merge_sort(nums)
        count = 0
        for i in range(len(arr)):
            for j in range(i+1, len(arr)):
                if arr[i] > 2 * arr[j]:
                    count += 1
        return count