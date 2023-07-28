impl Solution {
    pub fn transpose(matrix: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut matrix_t: Vec<Vec<i32>> = Vec::new();
        for i in 0..matrix[0].len() {
            let mut row: Vec<i32> = Vec::new();
            for j in 0..matrix.len() {
                row.push(matrix[j][i]);
            }
            matrix_t.push(row);
        }
        matrix_t
    }
}