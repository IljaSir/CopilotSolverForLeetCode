impl Solution {
    pub fn count_pairs(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut count = 0;
        let len = nums.len();
        for i in 0..len {
            for j in i+1..len {
                if nums[i] == nums[j] && (i*j) % k == 0 {
                    count += 1;
                }
            }
        }
        count
    }
}