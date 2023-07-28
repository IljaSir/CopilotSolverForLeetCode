class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        
        def merge_sort(arr):
            if len(arr) <= 1:
                return arr, 0
            mid = len(arr) // 2
            left, l_count = merge_sort(arr[:mid])
            right, r_count = merge_sort(arr[mid:])
            count = l_count + r_count
            i = j = 0
            while i < len(left) and j < len(right):
                if left[i] <= 2 * right[j]:
                    i += 1
                else:
                    count += len(left) - i
                    j += 1
            arr = sorted(left + right)
            return arr, count
        arr, count = merge_sort(nums)
        return count