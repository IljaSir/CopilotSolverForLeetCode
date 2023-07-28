impl Solution {
    pub fn spiral_order(matrix: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut res: Vec<i32> = Vec::new();
        let m = matrix.len();
        if m == 0 {
            return res;
        }
        let n = matrix[0].len();
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut l = 0;
        while i < m && j < n {
            for k in j..n {
                res.push(matrix[i][k]);
            }
            i += 1;
            for k in i..m {
                res.push(matrix[k][n - 1]);
            }
            n -= 1;
            if i < m {
                for k in (j..n).rev() {
                    res.push(matrix[m - 1][k]);
                }
                m -= 1;
            }
            if j < n {
                for k in (i..m).rev() {
                    res.push(matrix[k][j]);
                }
                j += 1;
            }
        }
        res
    }
}