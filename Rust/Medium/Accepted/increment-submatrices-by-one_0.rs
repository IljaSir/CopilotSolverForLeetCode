impl Solution {
    pub fn range_add_queries(n: i32, queries: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut mat = vec![vec![0; n as usize]; n as usize];
        for q in queries {
            mat[q[0] as usize][q[1] as usize] += 1;
            if q[2] + 1 < n {
                mat[(q[2] + 1) as usize][q[1] as usize] -= 1;
            }
            if q[3] + 1 < n {
                mat[q[0] as usize][(q[3] + 1) as usize] -= 1;
            }
            if q[2] + 1 < n && q[3] + 1 < n {
                mat[(q[2] + 1) as usize][(q[3] + 1) as usize] += 1;
            }
        }
        for i in 0..n as usize {
            for j in 1..n as usize {
                mat[i][j] += mat[i][j - 1];
            }
        }
        for i in 1..n as usize {
            for j in 0..n as usize {
                mat[i][j] += mat[i - 1][j];
            }
        }
        mat
    }
}