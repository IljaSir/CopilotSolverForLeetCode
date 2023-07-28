impl Solution {
    pub fn max_alternating_sum(nums: Vec<i32>) -> i64 {
        
        let mut odd = 0;
        let mut even = 0;
        for i in nums {
            let mut tmp = odd;
            odd = even + i;
            even = std::cmp::max(even, tmp);
        }
        std::cmp::max(odd, even) as i64
    }
}