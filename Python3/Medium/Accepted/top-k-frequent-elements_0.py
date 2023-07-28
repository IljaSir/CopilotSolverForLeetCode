class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        count = {}
        for num in nums:
            if num in count:
                count[num] += 1
            else:
                count[num] = 1
        count = sorted(count.items(), key=lambda x: x[1], reverse=True)
        return [item[0] for item in count[:k]]