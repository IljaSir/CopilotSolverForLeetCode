impl Solution {
    pub fn find_diagonal_order(mat: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut result = Vec::new();
        let mut i = 0;
        let mut j = 0;
        let mut is_up = true;
        let m = mat.len();
        let n = mat[0].len();
        while i < m && j < n {
            result.push(mat[i][j]);
            if is_up {
                if j == n - 1 {
                    i += 1;
                    is_up = false;
                } else if i == 0 {
                    j += 1;
                    is_up = false;
                } else {
                    i -= 1;
                    j += 1;
                }
            } else {
                if i == m - 1 {
                    j += 1;
                    is_up = true;
                } else if j == 0 {
                    i += 1;
                    is_up = true;
                } else {
                    i += 1;
                    j -= 1;
                }
            }
        }
        result
    }
}