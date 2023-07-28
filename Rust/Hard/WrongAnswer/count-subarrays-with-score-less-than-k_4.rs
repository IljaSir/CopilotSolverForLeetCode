impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i64) -> i64 {
        
        let mut res = 0;
        let mut prod = 1;
        let mut start = 0;
        let mut end = 0;
        while end < nums.len() {
            prod *= nums[end] as i64;
            end += 1;
            while prod >= k && start < end {
                prod /= nums[start] as i64;
                start += 1;
            }
            res += (end - start) as i64;
        }
        res
    }
}