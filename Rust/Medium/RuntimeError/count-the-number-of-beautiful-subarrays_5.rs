impl Solution {
    pub fn beautiful_subarrays(nums: Vec<i32>) -> i64 {
        
        let mut count = 0;
        let mut odd = vec![-1];
        for (i, num) in nums.iter().enumerate() {
            if num % 2 == 1 {
                odd.push(i as i32);
            }
        }
        odd.push(nums.len() as i32);
        for i in 1..odd.len() {
            count += (odd[i] - odd[i-1]) * (odd[i+1] - odd[i]);
        }
        count as i64
    }
}