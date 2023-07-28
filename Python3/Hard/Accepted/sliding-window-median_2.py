class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        
        def get_median(l):
            if len(l) % 2 == 0:
                return (l[len(l) // 2] + l[len(l) // 2 - 1]) / 2
            else:
                return l[len(l) // 2]
        l = sorted(nums[:k])
        result = [get_median(l)]
        for i in range(k, len(nums)):
            l.remove(nums[i - k])
            bisect.insort(l, nums[i])
            result.append(get_median(l))
        return result