class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        
        # This is the fastest solution I can think of
        # The idea is to find the node that has the most edges
        # The center node will have the most edges
        # The center node will be connected to all other nodes
        # so it will have n - 1 edges
        # The other nodes will have 1 edge
        # So we can count the number of edges for each node
        # and find the one with the most edges
        # We can use a dictionary to store the number of edges
        # for each node
        # The key will be the node number
        # The value will be the number of edges
        # The node with the most edges will have the most
        # value in the dictionary
        # We can use the max function to get the node with the
        # most edges
        # We can use the key function to get the node number
        # for the node with the most edges
        # We can use the get method to get the value for a key
        # in a dictionary
        # If the key is not in the dictionary, it will return 0
        # We can use the set function to get the unique values
        # in a list
        # We can use the len function to get the length of a list
        # We can use the range function to get a list of numbers
        # We can use the sum function to get the su