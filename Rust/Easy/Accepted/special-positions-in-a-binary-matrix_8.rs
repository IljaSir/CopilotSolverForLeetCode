impl Solution {
    pub fn num_special(mat: Vec<Vec<i32>>) -> i32 {
        
        let mut row = vec![0; mat.len()];
        let mut col = vec![0; mat[0].len()];
        for (i, v) in mat.iter().enumerate() {
            for (j, w) in v.iter().enumerate() {
                row[i] += w;
                col[j] += w;
            }
        }
        let mut ans = 0;
        for (i, v) in mat.iter().enumerate() {
            for (j, w) in v.iter().enumerate() {
                if *w == 1 && row[i] == 1 && col[j] == 1 {
                    ans += 1;
                }
            }
        }
        ans
    }
}