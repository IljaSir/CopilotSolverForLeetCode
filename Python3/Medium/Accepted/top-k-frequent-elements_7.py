class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        # Approach #1, priority queue
        # Time: O(nlogk), Space: O(n)
        # return [i[0] for i in Counter(nums).most_common(k)]
        # Approach #2, bucket sort
        # Time: O(n), Space: O(n)
        count = collections.Counter(nums)
        bucket = [[] for _ in range(len(nums) + 1)]
        for key, val in count.items():
            bucket[val].append(key)
        res = []
        for i in range(len(bucket) - 1, -1, -1):
            if bucket[i]:
                res += bucket[i]
            if len(res) >= k:
                return res[:k]
        return res