impl Solution {
    pub fn k_weakest_rows(mat: Vec<Vec<i32>>, k: i32) -> Vec<i32> {
        
        let mut v = Vec::with_capacity(mat.len());
        for i in 0..mat.len() {
            let mut j = 0;
            while j < mat[i].len() && mat[i][j] == 1 {
                j += 1;
            }
            v.push((j, i));
        }
        v.sort_by(|a, b| a.0.cmp(&b.0).then(a.1.cmp(&b.1)));
        v.iter().map(|x| x.1 as i32).take(k as usize).collect()
    }
}