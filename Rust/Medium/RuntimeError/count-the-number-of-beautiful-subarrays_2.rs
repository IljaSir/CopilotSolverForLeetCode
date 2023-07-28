impl Solution {
    pub fn beautiful_subarrays(nums: Vec<i32>) -> i64 {
        
        let mut odd = vec![-1];
        for (i, &n) in nums.iter().enumerate() {
            if n % 2 == 1 {
                odd.push(i as i32);
            }
        }
        odd.push(nums.len() as i32);
        let mut res = 0;
        for i in 1..odd.len() {
            res += (odd[i] - odd[i - 1]) * (odd[i + 1] - odd[i]);
        }
        res as i64
    }
}