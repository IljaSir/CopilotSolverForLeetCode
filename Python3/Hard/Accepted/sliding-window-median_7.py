class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        
        def median():
            if k % 2:
                return sorted_window[k // 2]
            return (sorted_window[k // 2] + sorted_window[k // 2 - 1]) / 2

        window, sorted_window = nums[:k], sorted(nums[:k])
        result = [median()]
        for i in range(k, len(nums)):
            del sorted_window[bisect_left(sorted_window, window.pop(0))]
            bisect.insort(sorted_window, nums[i])
            window.append(nums[i])
            result.append(median())
        return result