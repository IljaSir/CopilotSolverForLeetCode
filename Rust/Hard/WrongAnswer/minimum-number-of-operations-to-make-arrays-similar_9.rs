impl Solution {
    pub fn make_similar(nums: Vec<i32>, target: Vec<i32>) -> i64 {
        
        let mut res = 0;
        let mut diff = vec![0; 200001];
        for i in 0..nums.len() {
            let n = nums[i] as i64;
            let t = target[i] as i64;
            if n > t {
                diff[(n - t) as usize] += 1;
            } else if n < t {
                diff[(t - n) as usize + 100000] += 1;
            }
        }
        for i in 0..200001 {
            res += (diff[i] + 1) / 2;
        }
        res
    }
}