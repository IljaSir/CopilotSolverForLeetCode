impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        

        let (m, n) = (matrix.len(), matrix[0].len());
        let (mut r, mut c) = (0, n - 1);
        while r < m && c < n {
            if matrix[r][c] == target {
                return true;
            } else if matrix[r][c] > target {
                c -= 1;
            } else {
                r += 1;
            }
        }
        false
    }
}