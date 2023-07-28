impl Solution {
    pub fn matrix_reshape(mat: Vec<Vec<i32>>, r: i32, c: i32) -> Vec<Vec<i32>> {
        
        let m = mat.len() as i32;
        let n = mat[0].len() as i32;
        if m * n != r * c {
            return mat;
        }
        let mut ret = vec![vec![0; c as usize]; r as usize];
        for i in 0..m {
            for j in 0..n {
                let mut idx = i * n + j;
                let x = idx / c;
                let y = idx % c;
                ret[x as usize][y as usize] = mat[i as usize][j as usize];
            }
        }
        return ret;
    }
}