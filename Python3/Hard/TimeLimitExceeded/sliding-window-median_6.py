class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        
        def median(arr):
            arr_len = len(arr)
            if arr_len % 2 == 0:
                return (arr[arr_len // 2 - 1] + arr[arr_len // 2]) / 2
            else:
                return arr[arr_len // 2]
        ans = []
        left = 0
        right = k
        while right <= len(nums):
            ans.append(median(sorted(nums[left:right])))
            left += 1
            right += 1
        return ans