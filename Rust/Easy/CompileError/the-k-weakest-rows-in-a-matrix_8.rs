impl Solution {
    pub fn k_weakest_rows(mat: Vec<Vec<i32>>, k: i32) -> Vec<i32> {
        
        let mut tmp = mat.iter().map(|row| row.iter().sum()).collect::<Vec<i32>>();
        let mut res = Vec::new();
        for _ in 0..k {
            let min = tmp.iter().enumerate().min_by_key(|(_, &v)| v).unwrap();
            res.push(min.0 as i32);
            tmp[min.0] = i32::max_value();
        }
        res
    }
}