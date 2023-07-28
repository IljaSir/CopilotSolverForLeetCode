impl Solution {
    pub fn matrix_reshape(mat: Vec<Vec<i32>>, r: i32, c: i32) -> Vec<Vec<i32>> {
        
        let m = mat.len();
        let n = mat[0].len();
        if m * n != (r * c) as usize {
            return mat;
        }
        let mut res = vec![vec![0; c as usize]; r as usize];
        for i in 0..m {
            for j in 0..n {
                let k = i * n + j;
                res[k / c as usize][k % c as usize] = mat[i][j];
            }
        }
        res
    }
}