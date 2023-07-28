class Solution:
    def closetTarget(self, words: List[str], target: str, startIndex: int) -> int:
        
        
        def get_dist(i, j):
            if i == -1 or j == -1:
                return -1
            if i <= j:
                return j - i
            else:
                return len(words) - (i - j)
        
        def get_left(i):
            if i == -1:
                return -1
            for j in range(i - 1, -1, -1):
                if words[j] == target:
                    return j
            return -1
        
        def get_right(i):
            if i == -1:
                return -1
            for j in range(i + 1, len(words)):
                if words[j] == target:
                    return j
            return -1
        
        left = get_left(startIndex)
        right = get_right(startIndex)
        ans = get_dist(startIndex, left)
        ans = min(ans, get_dist(startIndex, right))
        
        for i in range(len(words)):
            if words[i] == target:
                continue
            l = get_left(i)
            r = get_right(i)
            ans = min(ans, get_dist(i, l), get_dist(i, r))
        return ans