impl Solution {
    pub fn check_valid(matrix: Vec<Vec<i32>>) -> bool {
        
        let n = matrix.len();
        let mut row = vec![false; n];
        let mut col = vec![false; n];
        for i in 0..n {
            for j in 0..n {
                if matrix[i][j] < 1 || matrix[i][j] > n as i32 {
                    return false;
                }
                if matrix[i][j] == 1 {
                    row[i] = true;
                }
                if matrix[i][j] == 2 {
                    col[j] = true;
                }
            }
        }
        for i in 0..n {
            if !row[i] || !col[i] {
                return false;
            }
        }
        true
    }
}