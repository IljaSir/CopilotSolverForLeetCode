class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        
        # 1. Find out all the equalities and inequalities
        # 2. Assign a unique number to each variable
        # 3. Check if the number is the same for all the equalities
        # 4. Check if the number is different for all the inequalities
        # 5. If all the checks are passed, return True
        # 6. Otherwise, return False
        # Time complexity: O(n)
        # Space complexity: O(n)
        # n: number of equations
        # The below solution is a bit slow because of the use of the list.index() function.
        # The time complexity of the list.index() function is O(n)
        # We can use a dictionary instead of a list to reduce the time complexity
        # The time complexity of the dictionary.get() function is O(1)
        # The space complexity of the dictionary is O(n)
        # n: number of equations
        # We can also use a union-find data structure to make the program faster.
        # The time complexity of the union-find data structure is O(1)
        # The space complexity of the union-find data structure is O(n)
        # n: number of equations
        # We can also use a graph to make the program faster.
        # The time complexity of the graph is O(1)
        # The space complexity of the graph is O(n)
        # n: number of equations
        # The below solution uses the union-find data structure
        # The time complexity of the union-find data structure is O(1)
        # The space complexity of the union-find data structure is O(n)
        # n: number of equations
        # The below solution uses the graph
        # The time complexity of the graph is O(1)
        # The space complexity of the graph is O(n)
        # n: number of equations
        # The below solution uses the dictionary
        # The time complexity of the dictionary.get() function is O(1)
        # The space complexity of the dictionary is O(n)
        # n: number of equations
        # The below solution uses the list
        # The time complexity of the list.index() function is O(n)
        # The space complexity of the list is O(n)
        # n: number of equations
        # The below solution uses the union-find data structure
        # The time