impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        

        let m = matrix.len();
        let n = matrix[0].len();
        let mut i = 0;
        let mut j = n - 1;
        while i < m && j >= 0 {
            if matrix[i][j] == target {
                return true;
            }
            if matrix[i][j] < target {
                i += 1;
            } else {
                j -= 1;
            }
        }
        false
    }
}