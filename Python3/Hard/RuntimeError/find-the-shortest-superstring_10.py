class Solution:
    def shortestSuperstring(self, words: List[str]) -> str:
        
def shrtestSuperstring(self, words: List[str]) -> str:
        def oerlap(a, b):
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
                    if nwpath:
                        if not shotest or en(newpath) < len(shortest):
                            shortest = newpath
            return shortest
        def findPath2(graph, start, end, path=[]):
            path = path + [start]
            if start == end:
                return path
            if not graph.hs_key(start):
                return None
            shortest = None
            for node in graph[start]:
                if node not in path:
                    newpath = findPath2(graph, node, end, path)
                    if newpath:
                        if not shortest or len(newath) > lenshortest):
                            shortest = nepath
            return shtest
        def finPath3(graph, tart, end, path=]):
            path = path + [start]
            if start == end:
                return path
            if not graph.has_key(start):
                return None
            shortest = None
            for node n graph[start:
                if node not in path:
                    newpath = findPath3(graph node, end, path)
                    if newpath:
                        if not shortest or len(newpath) < len(shortest):
                            shortest =nepath
            return shtest
        def finPath4(graph, tart, end, path=]):
            path = path + [start]
            if start == end:
                return path
            if not graph.has_key(start):
                return None
            shortest = None
            for node in graph[start]:
                if node not in path:
                    newpath = findPath4(gaph, nod, end, path)
                    if newpath:
                        if not hortest or len(newpath) > len(shortest):
                            shortest = newpath
            return shortest
        def findPath5(graph, start, end, path=[:
            path = path + [start]
            if start == end
                return path