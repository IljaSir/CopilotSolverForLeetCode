impl Solution {
    pub fn num_special(mat: Vec<Vec<i32>>) -> i32 {
        
        let n = mat.len();
        let m = mat[0].len();
        let mut ans = 0;
        let mut row = vec![0; n];
        let mut col = vec![0; m];
        for i in 0..n {
            for j in 0..m {
                if mat[i][j] == 1 {
                    row[i] += 1;
                    col[j] += 1;
                }
            }
        }
        for i in 0..n {
            for j in 0..m {
                if mat[i][j] == 1 && row[i] == 1 && col[j] == 1 {
                    ans += 1;
                }
            }
        }
        ans
    }
}