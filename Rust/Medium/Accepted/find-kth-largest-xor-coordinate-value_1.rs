impl Solution {
    pub fn kth_largest_value(matrix: Vec<Vec<i32>>, k: i32) -> i32 {
        
        let mut v = vec![vec![0; matrix[0].len()]; matrix.len()];
        let mut res = vec![];
        for i in 0..matrix.len() {
            for j in 0..matrix[i].len() {
                if i == 0 && j == 0 {
                    v[i][j] = matrix[i][j];
                } else if i == 0 {
                    v[i][j] = v[i][j-1] ^ matrix[i][j];
                } else if j == 0 {
                    v[i][j] = v[i-1][j] ^ matrix[i][j];
                } else {
                    v[i][j] = v[i-1][j] ^ v[i][j-1] ^ v[i-1][j-1] ^ matrix[i][j];
                }
                res.push(v[i][j]);
            }
        }
        res.sort();
        res[res.len() - k as usize]
    }
}