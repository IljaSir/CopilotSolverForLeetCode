impl Solution {
    pub fn transpose(matrix: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut result = Vec::with_capacity(matrix[0].len());
        for i in 0..matrix[0].len() {
            let mut row = Vec::with_capacity(matrix.len());
            for j in 0..matrix.len() {
                row.push(matrix[j][i]);
            }
            result.push(row);
        }
        result
    }
}