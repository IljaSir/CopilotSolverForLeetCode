class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        
        if len(mat) * len(mat[0]) != r * c:
            return mat
        else:
            new_mat = []
            for row in mat:
                for item in row:
                    if len(new_mat) == 0 or len(new_mat[-1]) == c:
                        new_mat.append([item])
                    else:
                        new_mat[-1].append(item)
            return new_mat