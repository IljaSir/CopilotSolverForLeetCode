impl Solution {
    pub fn k_weakest_rows(mat: Vec<Vec<i32>>, k: i32) -> Vec<i32> {
        
        let mut v = mat.iter().enumerate().map(|(i, row)| (i, row.iter().sum())).collect::<Vec<_>>();
        v.sort_by_key(|&(_, sum)| sum);
        v.iter().map(|&(i, _)| i as i32).take(k as usize).collect()
    }
}