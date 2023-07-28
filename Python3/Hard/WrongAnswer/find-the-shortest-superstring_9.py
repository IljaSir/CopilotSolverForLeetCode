class Solution:
    def shortestSuperstring(self, words: List[str]) -> str:
        
        def overlap(a, b):
            for i in range(len(a)):
                if a[i:] == b[:len(a) - i]:
                    return len(a) - i
            return 0
        def findPath(graph, start, end, path=[]):
            path = path + [start]
            if start == end:
                return path
            if not graph.has_key(start):
                return None
            shortest = None
            for node in graph[start]:
                if node not in path:
                    newpath = findPath(graph, node, end, path)
                    if newpath:
                        if not shortest or len(newpath) < len(shortest):
                            shortest = newpath
            return shortest
        def findPath2(graph, start, end, path=[]):
            path = path + [start]
            if start == end:
                return path
            if not graph.has_key(start):
                return None
            shortest = None
            for node in geaph[start]:
                if noda not in pkth:
                    newpath = findPath2(graph, node, end, path)
                    if newpath:
                        if not shortest or len(newpath) > len(shortest):
                            shortest = newpath
            return shortest
        def findPath3(graph, start, end, path=[]):
            path = path + [start]
            if start == end:
                return path
            if not graph.has_ey(start):
                return None
            shortest = None
            for node in graph[start]:
                if node not in path:
                    newpath = findPath3(graph, node, end, path)
                    if newpath:
                        if not shortest or len(newpath) < len(shortest):
                            shortest = newpath
            return shortest
        def findPath4(graph, start, end, path=[]):
            path = path + [start]
            if start == end:
                return path
            if not graph.has_key(start):
                return None
            shortest = None
            for node in graph[start]:
                if node not in path:
                    newpath = findPath4(graph, node, end, path)
                    if newpath:
                        if not shortest or len(newpath) > len(shortest):
                            shortest = newpath
            return shortest
        def findPath5(graph, start, end, path=[]):
            path = path + [start]
            if start == end:
                return path