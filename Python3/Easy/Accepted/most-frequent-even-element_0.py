class Solution:
    def mostFrequentEven(self, nums: List[int]) -> int:
        
        # # O(n) time and space
        # counts = {}
        # for num in nums:
        #     if num % 2 == 0:
        #         counts[num] = counts.get(num, 0) + 1
        # max_count = max(counts.values(), default=-1)
        # if max_count == -1:
        #     return -1
        # return min([num for num, count in counts.items() if count == max_count])
        # O(n) time and O(1) space
        counts = [0] * 100001
        for num in nums:
            if num % 2 == 0:
                counts[num] += 1
        max_count = max(counts)
        if max_count == 0:
            return -1
        return counts.index(max_count)