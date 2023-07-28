impl Solution {
    pub fn matrix_reshape(mat: Vec<Vec<i32>>, r: i32, c: i32) -> Vec<Vec<i32>> {
        
        let r = r as usize;
        let c = c as usize;
        let m = mat.len();
        let n = mat[0].len();
        if m * n != r * c {
            return mat;
        }
        let mut res: Vec<Vec<i32>> = vec![vec![0; c]; r];
        for i in 0..m {
            for j in 0..n {
                let idx = i * n + j;
                res[idx / c][idx % c] = mat[i][j];
            }
        }
        res
    }
}