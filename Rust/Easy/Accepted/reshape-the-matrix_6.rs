impl Solution {
    pub fn matrix_reshape(mat: Vec<Vec<i32>>, r: i32, c: i32) -> Vec<Vec<i32>> {
        
        let (m, n) = (mat.len(), mat[0].len());
        if m * n != (r * c) as usize { return mat; }
        let mut ans = vec![vec![0; c as usize]; r as usize];
        for i in 0..m {
            for j in 0..n {
                ans[(i * n + j) / c as usize][(i * n + j) % c as usize] = mat[i][j];
            }
        }
        ans
    }
}