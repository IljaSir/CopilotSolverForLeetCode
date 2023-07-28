class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        
        def get_median(arr):
            if len(arr) % 2 == 0:
                return (arr[len(arr) // 2] + arr[len(arr) // 2 - 1]) / 2
            else:
                return arr[len(arr) // 2]
        arr = sorted(nums[:k])
        res = [get_median(arr)]
        for i in range(k, len(nums)):
            arr.remove(nums[i - k])
            bisect.insort(arr, nums[i])
            res.append(get_median(arr))
        return res