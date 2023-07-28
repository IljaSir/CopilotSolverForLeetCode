impl Solution {
    pub fn median_sliding_window(nums: Vec<i32>, k: i32) -> Vec<f64> {
        
        let mut res = vec![];
        let mut v = nums;
        let mut i = 0;
        let mut j = k as usize;
        while j <= v.len() {
            let mut tmp = v[i..j].to_vec();
            tmp.sort();
            if k % 2 == 0 {
                res.push((tmp[(k / 2 - 1) as usize] + tmp[(k / 2) as usize]) as f64 / 2.0);
            } else {
                res.push(tmp[(k / 2) as usize] as f64);
            }
            i += 1;
            j += 1;
        }
        res
    }
}