class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        # Topological sort
        # Build graph
        graph = defaultdict(list)
        for a, b in prerequisites:
            graph[a].append(b)
        
        # Init status
        status = [0] * numCourses
        # 0: not visited
        # 1: visiting
        # 2: visited
        
        # Init result
        res = []
        
        # DFS
        def dfs(i):
            # If visiting, there is a cycle
            if status[i] == 1:
                return False
            
            # If visited, skip
            if status[i] == 2:
                return True
            
            # Mark visiting
            status[i] = 1
            
            # DFS
            for j in graph[i]:
                if not dfs(j):
                    return False
            
            # Mark visited
            status[i] = 2
            
            # Add to result
            res.append(i)
            
            return True
        
        # Check all courses
        for i in range(numCourses):
            if not dfs(i):
                return []
        
        # Return result
        return res