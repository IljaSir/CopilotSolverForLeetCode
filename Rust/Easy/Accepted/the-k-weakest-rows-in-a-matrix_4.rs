impl Solution {
    pub fn k_weakest_rows(mat: Vec<Vec<i32>>, k: i32) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut tmp = Vec::new();
        for (i, v) in mat.iter().enumerate() {
            tmp.push((i, v.iter().filter(|&x| *x == 1).count()));
        }
        tmp.sort_by(|a, b| a.1.cmp(&b.1));
        for i in 0..k as usize {
            res.push(tmp[i].0 as i32);
        }
        res
    }
}