impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        

        let mut (mut i, mut j) = (0, matrix[0].len() - 1);
        while i < matrix.len() && j >= 0 {
            if matrix[i][j] == target {
                return true;
            } else if matrix[i][j] > target {
                j -= 1;
            } else {
                i += 1;
            }
        }
        false
    }
}