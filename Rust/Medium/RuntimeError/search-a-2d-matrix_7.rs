impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        

        let mut l = 0;
        let mut r = matrix.len() * matrix[0].len() - 1;
        while l <= r {
            let m = (l + r) / 2;
            let (i, j) = (m / matrix[0].len(), m % matrix[0].len());
            if matrix[i][j] == target {
                return true;
            } else if matrix[i][j] < target {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        false
    }
}