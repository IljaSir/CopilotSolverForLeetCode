impl Solution {
    pub fn reverse_pairs(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                if nums[i] > 2*nums[j] {
                    count += 1;
                }
            }
        }
        count
    }
}