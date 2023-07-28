impl Solution {
    pub fn beautiful_subarrays(nums: Vec<i32>) -> i64 {
        
        let mut odd = vec![-1];
        for (i, &num) in nums.iter().enumerate() {
            if num % 2 == 1 {
                odd.push(i as i64);
            }
        }
        odd.push(nums.len() as i64);
        let mut ans = 0;
        for i in 1..odd.len() {
            ans += (odd[i] - odd[i - 1]) * (odd[i + 1] - odd[i]);
        }
        ans as i64
    }
}