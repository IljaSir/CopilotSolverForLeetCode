impl Solution {
    pub fn num_special(mat: Vec<Vec<i32>>) -> i32 {
        
        let mut r = vec![0; mat.len()];
        let mut c = vec![0; mat[0].len()];
        for (i, row) in mat.iter().enumerate() {
            for (j, &v) in row.iter().enumerate() {
                if v == 1 {
                    r[i] += 1;
                    c[j] += 1;
                }
            }
        }
        let mut res = 0;
        for (i, row) in mat.iter().enumerate() {
            for (j, &v) in row.iter().enumerate() {
                if v == 1 && r[i] == 1 && c[j] == 1 {
                    res += 1;
                }
            }
        }
        res
    }
}