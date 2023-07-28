class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:
        
        # O(N)
        # O(1)
        res = 0
        avg = threshold * k
        curr = sum(arr[:k])
        if curr >= avg:
            res += 1
        for i in range(k, len(arr)):
            curr += arr[i] - arr[i - k]
            if curr >= avg:
                res += 1
        return res