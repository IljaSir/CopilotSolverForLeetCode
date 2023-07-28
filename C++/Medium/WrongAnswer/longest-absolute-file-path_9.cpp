class Solution {
public:
    int lengthLongestPath(string input) {
        
        int longestPath = 0;
        int currentPath = 0;
        int currentFolder = 0;
        int currentFile = 0;
        int currentLevel = 0;
        int level = 0;
        bool isFile = false;
        for (int i = 0; i < input.length(); i++) {
            if (input[i] == '\n') {
                if (isFile) {
                    if (currentLevel == level) {
                        currentPath = currentPath - currentFile + currentFolder;
                    }
                    else if (currentLevel < level) {
                        currentPath = currentPath - currentFile - currentLevel + currentFolder + level;
                    }
                    else {
                        currentPath = currentPath - currentFile + currentFolder;
                    }
                    if (currentPath > longestPath) {
                        longestPath = currentPath;
                    }
                    currentFile = 0;
                    isFile = false;
                }
                else {
                    if (currentLevel == level) {
                        currentPath = currentPath + currentFolder;
                    }
                    else if (currentLevel < level) {
                        currentPath = currentPath - currentLevel + currentFolder + level;
                    }
                    else {
                        currentPath = currentPath + currentFolder;
                    }
                    currentFolder = 0;
                }
                currentLevel = 0;
                level = 0;
            }
            else if (input[i] == '\t') {
                level++;
            }
            else if (input[i] == '.') {
                isFile = true;
                currentFile++;
            }
            else {
                if (isFile) {
                    currentFile++;
                }
                else {
                    currentFolder++;
                }
            }
        }
        if (isFile) {
            if (currentLevel == level) {
                currentPath = currentPath - currentFile + currentFolder;
            }
            else if (currentLevel < level) {
                currentPath = currentPath - currentFile - currentLevel + currentFolder + level;
            }
            else {
                currentPath = currentPath - currentFile + currentFolder;
            }
            if (currentPath > longestPath) {
                longestPath = currentPath;
            }
        }
        return longestPath;
    }
};