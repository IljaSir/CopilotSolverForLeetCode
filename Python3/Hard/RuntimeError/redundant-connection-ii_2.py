class Solution:
    def findRedundantDirectedConnection(self, edges: List[List[int]]) -> List[int]:
        
        
        # find the node with two parents
        parents = {}
        for edge in edges:
            if edge[1] not in parents:
                parents[edge[1]] = []
            parents[edge[1]].append(edge[0])
        
        # find the node with two parents
        node = -1
        for key in parents:
            if len(parents[key]) == 2:
                node = key
                break
        if node == -1:
            return self.findRedundantConnection(edges)
        
        # remove the edge that leads to the node with two parents
        for edge in edges:
            if edge[1] == node and edge[0] == parents[node][0]:
                edges.remove(edge)
                break
        
        # check if the graph is a tree
        if self.findRedundantConnection(edges) == []:
            return edge
        else:
            return parents[node][1], node