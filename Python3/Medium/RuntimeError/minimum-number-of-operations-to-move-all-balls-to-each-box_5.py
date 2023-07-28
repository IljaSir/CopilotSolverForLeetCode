class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        
        # Solution 1: Brute Force
        # Time  complexity: O(N^2)
        # Space complexity: O(N)
        # N = len(boxes)
        # ans = [0] * N
        # for i in range(N):
        #     for j in range(N):
        #         if boxes[j] == "1":
        #             ans[i] += abs(i - j)
        # return ans

        # Solution 2: Prefix Sums
        # Time  complexity: O(N)
        # Space complexity: O(N)
        # N = len(boxes)
        # ans = [0] * N
        # total = 0
        # for i in range(N):
        #     ans[i] += total
        #     total += int(boxes[i])
        # total = 0
        # for i in range(N - 1, -1, -1):
        #     ans[i] += total
        #     total += int(boxes[i])
        # return ans

        # Solution 3: Suffix Sums
        # Time  complexity: O(N)
        # Space complexity: O(N)
        # N = len(boxes)
        # ans = [0] * N
        # total = 0
        # for i in range(N - 1, -1, -1):
        #     ans[i] += total
        #     total += int(boxes[i])
        # total = 0
        # for i in range(N):
        #     ans[i] += total
        #     total += int(boxes[i])
        # return ans

        # Solution 4: One Pass
        # Time  complexity: O(N)
        # Space complexity: O(N)
        # N = len(boxes)
        # ans = [0] * N
        # total = 0
        # cnt = 0
        # for i in range(N):
        #     ans[i] += total
        #     cnt += int(boxes[i])
        #     total += cnt
        # total = cnt = 0
        # for i in range(N - 1, -1, -1):
        #     ans[i] += total
        #     cnt += int(boxes[i])
        #     total += cnt
        # return ans

        # Solution