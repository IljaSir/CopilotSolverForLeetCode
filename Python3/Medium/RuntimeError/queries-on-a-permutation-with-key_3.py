class Solution:
    def processQueries(self, queries: List[int], m: int) -> List[int]:
        
        
        # 1. create a list of numbers from 1 to m
        # 2. for each query, find the position of the query in the list
        # 3. move the query to the front of the list
        # 4. add the index of the query to a list
        # 5. return the list of indices
        
        # 1. create a list of numbers from 1 to m
        p = list(range(1, m+1))
        # 2. for each query, find the position of the query in the list
        # 3. move the query to the front of the list
        # 4. add the index of the query to a list
        # 5. return the list of indices
        return [p.pop(p.index(q)) for q in queries]