class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        num_count = {}
        for num in nums:
            if num in num_count:
                num_count[num] += 1
            else:
                num_count[num] = 1
        num_count = sorted(num_count.items(), key=lambda x: x[1], reverse=True)
        return [num_count[i][0] for i in range(k)]