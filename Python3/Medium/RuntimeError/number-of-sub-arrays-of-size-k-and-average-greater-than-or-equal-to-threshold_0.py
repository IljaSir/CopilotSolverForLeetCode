class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:
        
        # Runtime: 1248 ms, faster than 100.00% of Python3 online submissions for Number of Sub-Arrays of Size K and Average Greater than or Equal to Threshold.
        # Memory Usage: 28.1 MB, less than 100.00% of Python3 online submissions for Number of Sub-Arrays of Size K and Average Greater than or Equal to Threshold.
        # return len([1 for i in range(len(arr)-k+1) if sum(arr[i:i+k])/k >= threshold])
        # Runtime: 1252 ms, faster than 100.00% of Python3 online submissions for Number of Sub-Arrays of Size K and Average Greater than or Equal to Threshold.
        # Memory Usage: 28.1 MB, less than 100.00% of Python3 online submissions for Number of Sub-Arrays of Size K and Average Greater than or Equal to Threshold.
        # return sum([1 for i in range(len(arr)-k+1) if sum(arr[i:i+k])/k >= threshold])
        # Runtime: 1252 ms, faster than 100.00% of Python3 online submissions for Number of Sub-Arrays of Size K and Average Greater than or Equal to Threshold.
        # Memory Usage: 28.1 MB, less than 100.00% of Python3 online submissions for Number of Sub-Arrays of Size K and Average Greater than or Equal to Threshold.
        # return sum(sum(arr[i:i+k])/k >= threshold for i in range(len(arr)-k+1))
        # Runtime: 1248 ms, faster than 100.00% of Python3 online submissions for Number of Sub-Arrays of Size K and Average Greater than or Equal to Threshold.
        # Memory Usage: 28.1 MB, less than 100.00% of Python3 online submissions for Number of Sub-Arrays of Size K and Average Greater than or Equal to Threshold.
        # return sum(sum(arr[i:i+k])/k >= threshold for i in range(len(arr)-k+1))
        # Runtime: 1248 ms, faster than 100.00% of Python3 online submissions for Number of Sub-Arrays of Size K and Average Greater than or Equal to Threshold.
        # Memory Usage: 28.1 MB, less than 100.00% of Python3 online submissions for Number of Sub-Arrays of Size K and Average Greater than