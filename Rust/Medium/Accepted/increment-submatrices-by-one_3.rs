impl Solution {
    pub fn range_add_queries(n: i32, queries: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut mat = vec![vec![0; n as usize]; n as usize];
        for q in queries {
            let (r1, c1, r2, c2) = (q[0] as usize, q[1] as usize, q[2] as usize, q[3] as usize);
            mat[r1][c1] += 1;
            if r2 + 1 < n as usize {
                mat[r2 + 1][c1] -= 1;
            }
            if c2 + 1 < n as usize {
                mat[r1][c2 + 1] -= 1;
            }
            if r2 + 1 < n as usize && c2 + 1 < n as usize {
                mat[r2 + 1][c2 + 1] += 1;
            }
        }
        for i in 0..n as usize {
            for j in 0..n as usize {
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