impl Solution {
    pub fn range_add_queries(n: i32, queries: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let n = n as usize;
        let mut mat = vec![vec![0; n]; n];
        for query in &queries {
            let (row1, col1, row2, col2) = (query[0] as usize, query[1] as usize, query[2] as usize, query[3] as usize);
            mat[row1][col1] += 1;
            if row2 + 1 < n {
                mat[row2 + 1][col1] -= 1;
            }
            if col2 + 1 < n {
                mat[row1][col2 + 1] -= 1;
            }
            if row2 + 1 < n && col2 + 1 < n {
                mat[row2 + 1][col2 + 1] += 1;
            }
        }
        for i in 0..n {
            for j in 0..n {
                if i > 0 {
                    mat[i][j] += mat[i - 1][j];
                }
                if j > 0 {
                    mat[i][j] += mat[i][j - 1];
                }
                if i > 0 && j > 0 {
                    mat[i][j] -= mat[i - 1][j - 1];
                }
            }
        }
        mat
    }
}