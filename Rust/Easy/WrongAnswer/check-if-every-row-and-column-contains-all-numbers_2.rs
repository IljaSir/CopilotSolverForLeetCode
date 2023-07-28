impl Solution {
    pub fn check_valid(matrix: Vec<Vec<i32>>) -> bool {
        
        let n = matrix.len();
        let mut row = vec![false; n];
        let mut col = vec![false; n];
        for i in 0..n {
            for j in 0..n {
                if matrix[i][j] == 1 {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        row.iter().all(|x| *x) && col.iter().all(|x| *x)
    }
}