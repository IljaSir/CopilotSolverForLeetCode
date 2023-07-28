class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        # Topological sort
        # https://en.wikipedia.org/wiki/Topological_sorting
        # https://www