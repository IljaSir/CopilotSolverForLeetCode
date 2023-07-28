class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        # This is a topological sorting problem. The algorithm is as follows:
        # 1. Construct the graph.
        # 2. Find the in-degree of each node.
        # 3. Find the nodes with 0 in-degree.
        # 4. For each node with 0 in-degree, remove the node and all edges
        #    coming out of the node, and update the in-degrees of the nodes
        #    that are connected to the removed node.
        # 5. Repeat steps 3 and 4 until all nodes are removed.
        # 6. If all nodes are removed, return the list of nodes in the order
        #    in which they were removed. Otherwise, return an empty list.
        graph = {}
        in_degree = {}
        for i in range(numCourses):
            graph[i] = []
            in_degree[i] = 0
        for edge in prerequisites:
            graph[edge[1]].append(edge[0])
            in_degree[edge[0]] += 1
        zero_in_degree = []
        for node in in_degree:
            if in_degree[node] == 0:
                zero_in_degree.append(node)
        order = []
        while zero_in_degree:
            node = zero_in_degree.pop(0)
            order.append(node)
            for neighbor in graph[node]:
                in_degree[neighbor] -= 1
                if in_degree[neighbor] == 0:
                    zero_in_degree.append(neighbor)
        if len(order) == numCourses:
            return order
        else:
            return []