impl Solution {
    pub fn median_sliding_window(nums: Vec<i32>, k: i32) -> Vec<f64> {
        
        let mut res = vec![];
        let mut window = vec![];
        for i in 0..nums.len() {
            if window.len() < k as usize {
                window.push(nums[i]);
            } else {
                window.remove(0);
                window.push(nums[i]);
            }
            if window.len() == k as usize {
                let mut w = window.clone();
                w.sort();
                if w.len() % 2 == 0 {
                    res.push((w[w.len() / 2 - 1] + w[w.len() / 2]) as f64 / 2.0);
                } else {
                    res.push(w[w.len() / 2] as f64);
                }
            }
        }
        res
    }
}