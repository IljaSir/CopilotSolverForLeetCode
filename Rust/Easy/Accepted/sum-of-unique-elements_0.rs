impl Solution {
    pub fn sum_of_unique(nums: Vec<i32>) -> i32 {
        
        let mut sum: i32 = 0;
        for i in 0..nums.len() {
            if nums.iter().filter(|&x| *x == nums[i]).count() == 1 {
                sum += nums[i];
            }
        }
        sum
    }
}