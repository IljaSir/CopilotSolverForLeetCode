impl Solution {
    pub fn k_weakest_rows(mat: Vec<Vec<i32>>, k: i32) -> Vec<i32> {
        
        let mut res: Vec<i32> = (0..mat.len() as i32).collect();
        res.sort_by_key(|&i| (mat[i as usize].iter().sum::<i32>(), i));
        res.truncate(k as usize);
        res
    }
}