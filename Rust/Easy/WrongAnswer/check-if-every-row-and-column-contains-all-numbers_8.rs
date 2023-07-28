impl Solution {
    pub fn check_valid(matrix: Vec<Vec<i32>>) -> bool {
        
        let mut row = vec![0; matrix.len()];
        let mut col = vec![0; matrix.len()];
        for i in 0..matrix.len() {
            for j in 0..matrix[i].len() {
                row[i] |= 1 << matrix[i][j];
                col[j] |= 1 << matrix[i][j];
            }
        }
        for i in 0..matrix.len() {
            if row[i] != (1 << (matrix.len() + 1)) - 2 {
                return false;
            }
            if col[i] != (1 << (matrix.len() + 1)) - 2 {
                return false;
            }
        }
        true
    }
}