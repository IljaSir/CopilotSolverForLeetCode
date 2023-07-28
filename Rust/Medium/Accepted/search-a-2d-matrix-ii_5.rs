impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        

        let mut row = 0;
        let mut col = matrix[0].len() - 1;
        while row < matrix.len() && col < matrix[0].len() {
            if matrix[row][col] == target {
                return true;
            } else if matrix[row][col] < target {
                row += 1;
            } else {
                col -= 1;
            }
        }
        false
    }
}