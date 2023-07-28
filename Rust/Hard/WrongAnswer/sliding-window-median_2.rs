impl Solution {
    pub fn median_sliding_window(nums: Vec<i32>, k: i32) -> Vec<f64> {
        
        let mut res = Vec::new();
        let mut window = nums[0..k as usize].to_vec();
        window.sort();
        let mut k = k as usize;
        let mut i = 0;
        while i + k <= nums.len() {
            if k % 2 == 0 {
                res.push((window[k / 2 - 1] + window[k / 2]) as f64 / 2.0);
            } else {
                res.push(window[k / 2] as f64);
            }
            if i + k == nums.len() {
                break;
            }
            window.remove(window.binary_search(&nums[i]).unwrap());
            window.insert(window.binary_search(&nums[i + k]).unwrap_or_else(|x| x), nums[i + k]);
            i += 1;
        }
        res
    }
}