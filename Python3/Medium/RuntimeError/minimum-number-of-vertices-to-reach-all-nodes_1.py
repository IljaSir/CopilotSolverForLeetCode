class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        
        
        # The idea is to find the nodes that have no incoming edges. 
        # The node that has no incoming edges is the starting point of the graph. 
        # So if we find all the nodes that have no incoming edges, 
        # we will get the nodes that we need to start from. 
        # The number of nodes that have no incoming edges is the number of nodes that we need to start from.
        
        # The graph is directed and acyclic. 
        # So the graph cannot have cycles. 
        # So we can use DFS to traverse the graph. 
        # We can use a set to store the nodes that have no incoming edges. 
        # We can use a set to store the nodes that have been visited. 
        # If a node has been visited, we do not need to traverse it again. 
        # We can use a set to store the nodes that have incoming edges. 
        # We can use a set to store the nodes that have outgoing edges. 
        # If a node has no incoming edges, it will not be in the nodes that have incoming edges. 
        # If a node has no outgoing edges, it will not be in the nodes that have outgoing edges. 
        # We can use a set to store the nodes that have been traversed. 
        # If a node has been traversed, we do not need to traverse it again. 
        # If a node has no incoming edges, it will be in the set of nodes that have no incoming edges. 
        # If a node has no outgoing edges, it will be in the set of nodes that have no outgoing edges. 
        # If a node has no incoming edges, it will not be in the set of nodes that have incoming edges. 
        # If a node has no outgoing edges, it will not be in the set of nodes that have outgoing edges. 
        # If a node has no incoming edges, it will not be in the set of nodes that have been traversed. 
        # If a node has no outgoing edges, it will not be in the set of nodes that have been traversed. 
        # If a node has no incoming edges, it will be in the set of nodes that have no incoming edges. 
        # If a node has no outgoing edges, it will be in the set of nodes that have no outgoing edges.