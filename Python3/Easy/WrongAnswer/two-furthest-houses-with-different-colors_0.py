class Solution:
    def maxDistance(self, colors: List[int]) -> int:
        
        answer = 0
        for i in range(100):
            left, right = -1, -1
            for j in range(len(colors)):
                if colors[j] == i:
                    if left == -1:
                        left = j
                    right = j
            if left == -1:
                continue
            answer = max(answer, right - left)
        return answer