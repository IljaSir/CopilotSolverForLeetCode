impl Solution {
    pub fn max_alternating_sum(nums: Vec<i32>) -> i64 {
        
        let mut odd = 0;
        let mut even = 0;
        for n in nums {
            let n = n as i64;
            odd = odd.max(even + n);
            even = even.max(odd - n);
        }
        odd
    }
}