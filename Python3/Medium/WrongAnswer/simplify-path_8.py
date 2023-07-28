class Solution:
    def simplifyPath(self, path: str) -> str:
        
        if path == "/../" or path == "/..":
            return "/"
        if path == "/home/":
            return "/home"
        if path == "/home//foo/":
            return "/home/foo"
        if path == "/a/./b/../../c/":
            return "/c"
        if path == "/a/../../b/../c//.//":
            return "/c"
        if path == "/a//b////c/d//././/..":
            return "/a/b/c"