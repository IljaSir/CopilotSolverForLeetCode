impl Solution {
    pub fn num_submat(mat: Vec<Vec<i32>>) -> i32 {
        
        let mut res = 0;
        let mut dp = vec![vec![0;mat[0].len()];mat.len()];
        for i in 0..mat.len(){
            for j in (0..mat[i].len()).rev(){
                if mat[i][j] == 1{
                    dp[i][j] = 1+dp[i][j+1];
                }
            }
        }
        for i in 0..mat.len(){
            for j in 0..mat[i].len(){
                if mat[i][j] == 1{
                    let mut min = dp[i][j];
                    for k in i..mat.len(){
                        min = std::cmp::min(min,dp[k][j]);
                        res += min;
                    }
                }
            }
        }
        res
    }
}