class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        
        # Greedy algorithm
        # Key: the last element of the sequence
        # Value: the length of the sequence
        d = {}
        for n in nums:
            if n-1 in d:
                # If n-1 exists, we can append it to the sequence
                # and we can decrease the length of the sequence
                d[n] = d[n-1] + 1
                d[n-1] -= 1
                if d[n-1] == 0:
                    del d[n-1]
            else:
                # If n-1 does not exist, we can create a new sequence
                d[n] = d.get(n, 0) + 1
        return all([v < 3 for v in d.values()])