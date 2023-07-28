class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        
        from sortedcontainers import SortedList
        n = len(nums)
        if k == 1:
            return nums
        if k == n:
            return [sum(nums) / n]
        window = SortedList(nums[:k])
        res = [window[k // 2] / 1.0 if k % 2 == 1 else (window[k // 2 - 1] + window[k // 2]) / 2.0]
        for i in range(k, n):
            window.remove(nums[i - k])
            window.add(nums[i])
            res.append(window[k // 2] / 1.0 if k % 2 == 1 else (window[k // 2 - 1] + window[k // 2]) / 2.0)
        return res