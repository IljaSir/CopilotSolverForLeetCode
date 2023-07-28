impl Solution {
    pub fn moves_to_make_zigzag(nums: Vec<i32>) -> i32 {
        
        let mut odd = 0;
        let mut even = 0;
        for i in 0..nums.len() {
            let (a, b) = if i % 2 == 0 {
                (nums.get(i + 1).unwrap_or(&1001), nums.get(i - 1).unwrap_or(&1001))
            } else {
                (nums.get(i - 1).unwrap_or(&1001), nums.get(i + 1).unwrap_or(&1001))
            };
            let c = nums[i];
            if c >= *a {
                even += c - a + 1;
            }
            if c >= *b {
                odd += c - b + 1;
            }
        }
        odd.min(even)
    }
}