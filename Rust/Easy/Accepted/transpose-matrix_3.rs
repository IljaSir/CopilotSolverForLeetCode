impl Solution {
    pub fn transpose(matrix: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut ret = vec![vec![0; matrix.len()]; matrix[0].len()];
        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                ret[j][i] = matrix[i][j];
            }
        }
        return ret;
    }
}