impl Solution {
    pub fn num_submat(mat: Vec<Vec<i32>>) -> i32 {
        
        let mut res = 0;
        for i in 0..mat.len() {
            for j in 0..mat[i].len() {
                if mat[i][j] == 1 {
                    let mut min = std::i32::MAX;
                    let mut k = j;
                    while k < mat[i].len() && mat[i][k] == 1 {
                        min = std::cmp::min(min, mat[i][k]);
                        res += min;
                        k += 1;
                    }
                }
            }
        }
        res
    }
}