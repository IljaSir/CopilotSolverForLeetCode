impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut max = 0;
        let mut prev = 0;
        for i in 0..nums.len() {
            if nums[i] == 1 {
                count += 1;
            } else {
                prev = count;
                count = 0;
            }
            max = std::cmp::max(max, prev + count + 1);
        }
        std::cmp::max(max - 1, 0)
    }
}