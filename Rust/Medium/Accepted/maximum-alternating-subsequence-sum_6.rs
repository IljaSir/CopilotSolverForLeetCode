impl Solution {
    pub fn max_alternating_sum(nums: Vec<i32>) -> i64 {
        
        let mut max_odd = 0;
        let mut max_even = 0;
        for num in nums {
            let num = num as i64;
            max_odd = std::cmp::max(max_odd, max_even + num);
            max_even = std::cmp::max(max_even, max_odd - num);
        }
        max_odd
    }
}