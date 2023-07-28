class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        
        # sliding window
        # min size of window
        # window = [i,j]
        # i = start of window
        # j = end of window
        # sum of window
        # min window size = j - i
        # if sum < k, j += 1
        # if sum > k, i += 1
        # if sum == k, return min window size
        # if sum > k, i += 1
        # if sum < k, j += 1
        # if sum == k, return min window size
        # if sum < k, j += 1
        # if sum > k, i += 1
        # if sum == k, return min window size
        # if sum > k, i += 1
        # if sum < k, j += 1
        # if sum == k, return min window size
        # if sum < k, j += 1
        # if sum > k, i += 1
        # if sum == k, return min window size
        # if sum > k, i += 1
        # if sum < k, j += 1
        # if sum == k, return min window size
        # if sum < k, j += 1
        # if sum > k, i += 1
        # if sum == k, return min window size
        # if sum > k, i += 1
        # if sum < k, j += 1
        # if sum == k, return min window size
        # if sum < k, j += 1
        # if sum > k, i += 1
        # if sum == k, return min window size
        # if sum > k, i += 1
        # if sum < k, j += 1
        # if sum == k, return min window size
        # if sum < k, j += 1
        # if sum > k, i += 1
        # if sum == k, return min window size
        # if sum > k, i += 1
        # if sum < k, j += 1
        # if sum == k, return min window size
        # if sum < k, j += 1
        # if