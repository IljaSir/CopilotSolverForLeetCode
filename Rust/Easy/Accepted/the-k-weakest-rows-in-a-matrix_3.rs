impl Solution {
    pub fn k_weakest_rows(mat: Vec<Vec<i32>>, k: i32) -> Vec<i32> {
        
        let mut r = Vec::with_capacity(mat.len());
        for (i, row) in mat.iter().enumerate() {
            let mut j = 0;
            while j < row.len() && row[j] == 1 {
                j += 1;
            }
            r.push((i, j));
        }
        r.sort_by_key(|a| a.1);
        r.iter().take(k as usize).map(|a| a.0 as i32).collect()
    }
}