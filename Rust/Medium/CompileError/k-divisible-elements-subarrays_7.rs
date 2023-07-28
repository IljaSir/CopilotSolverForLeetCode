impl Solution {
    pub fn count_distinct(nums: Vec<i32>, k: i32, p: i32) -> i32 {
        
        let mut counter = 0;
        for i in 0..nums.len() {
            let mut j = i;
            let mut c = 0;
            while j < nums.len() && c < k {
                if nums[j] % p == 0 {
                    c += 1;
                }
                j += 1;
            }
            counter += j - i;
        }
        counter
    }
}