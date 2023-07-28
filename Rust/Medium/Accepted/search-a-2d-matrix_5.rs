impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        

        let mut row = matrix.len() - 1;
        let mut col = 0;
        while row < matrix.len() && col < matrix[0].len() {
            if matrix[row][col] == target {
                return true;
            } else if matrix[row][col] > target {
                if row == 0 {
                    return false;
                } else {
                    row -= 1;
                }
            } else {
                col += 1;
            }
        }
        false
    }
}