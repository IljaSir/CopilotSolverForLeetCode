class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        
        visited = set()
        queue = collections.deque([start])
        while queue:
            i = queue.popleft()
            if arr[i] == 0: return True
            visited.add(i)
            for j in [i + arr[i], i - arr[i]]:
                if 0 <= j < len(arr) and j not in visited:
                    queue.append(j)
        return False