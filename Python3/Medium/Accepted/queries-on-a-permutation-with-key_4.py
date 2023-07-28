class Solution:
    def processQueries(self, queries: List[int], m: int) -> List[int]:
        
        # 1. Create a list of integers from 1 to m
        # 2. Create a list of integers from 1 to m
        # 3. Iterate over the queries
        # 4. For each query, get the index of the query from the list of integers from 1 to m
        # 5. Remove the query from the list of integers from 1 to m
        # 6. Insert the query at the beginning of the list of integers from 1 to m
        # 7. Add the index of the query to the result list
        # 8. Return the result list
        # Time complexity: O(n^2)
        # Space complexity: O(n)
        result = []
        nums = [i for i in range(1, m + 1)]
        for query in queries:
            index = nums.index(query)
            nums.remove(query)
            nums.insert(0, query)
            result.append(index)
        return result