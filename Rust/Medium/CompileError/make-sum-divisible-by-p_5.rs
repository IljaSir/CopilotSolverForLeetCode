impl Solution {
    pub fn min_subarray(nums: Vec<i32>, p: i32) -> i32 {
        
        let n = nums.len();
        let mut sum = 0;
        let mut m = std::collections::HashMap::new();
        m.insert(0, -1);
        let mut result = n as i32;
        for i in 0..n {
            sum = (sum + nums[i]) % p;
            m.insert(sum, i as i32);
        }
        sum = 0;
        for i in (0..n).rev() {
            sum = (sum + nums[i]) % p;
            if let Some(j) = m.get(&(p - sum) % p) {
                result = result.min((i as i32 - j) as i32);
            }
        }
        if result == n as i32 || sum != 0 { -1 } else { result }
    }
}