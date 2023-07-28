class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        
        # Solution 1: Brute Force
        # Time  complexity: O(N^2)
        # Space complexity: O(N)
        # N = len(boxes)
        # ans = [0] * N
        # for i in range(N):
        #     for j in range(N):
        #         if boxes[j] == '1':
        #             ans[i] += abs(i - j)
        # return ans

        # Solution 2: Prefix Sum
        # Time  complexity: O(N)
        # Space complexity: O(N)
        # N = len(boxes)
        # ans = [0] * N
        # prefix = [0] * N
        # for i in range(N):
        #     prefix[i] = prefix[i - 1] + int(boxes[i])
        #     ans[i] += prefix[i] - (i - prefix[i] + 1)
        # suffix = 0
        # for i in range(N - 1, -1, -1):
        #     suffix += int(boxes[i])
        #     ans[i] += suffix - (N - i - suffix)
        # return ans

        # Solution 3: Prefix Sum (Optimized)
        # Time  complexity: O(N)
        # Space complexity: O(N)
        N = len(boxes)
        ans = [0] * N
        prefix = 0
        for i in range(N):
            prefix += int(boxes[i])
            ans[i] += prefix - (i - prefix + 1)
        suffix = 0
        for i in range(N - 1, -1, -1):
            suffix += int(boxes[i])
            ans[i] += suffix - (N - i - suffix)
        return ans