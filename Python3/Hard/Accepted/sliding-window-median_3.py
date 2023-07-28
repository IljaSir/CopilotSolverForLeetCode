class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        
        def getMedian():
            if k % 2 == 1:
                return sortedNums[k // 2]
            else:
                return (sortedNums[k // 2] + sortedNums[k // 2 - 1]) / 2

        sortedNums = sorted(nums[:k])
        res = [getMedian()]
        for i in range(k, len(nums)):
            sortedNums.remove(nums[i - k])
            bisect.insort(sortedNums, nums[i])
            res.append(getMedian())
        return res