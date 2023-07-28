impl Solution {
    pub fn maximum_count(nums: Vec<i32>) -> i32 {
        
        nums.iter().filter(|&n| n < &0).count().max(nums.iter().filter(|&n| n > &0).count()) as i32
    }
}