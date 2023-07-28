impl Solution {
    pub fn special_array(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let len = nums.len();
        for i in 0..=1000 {
            let mut j = 0;
            while j < len && nums[j] < i {
                j += 1;
            }
            if len - j == i {
                return i as i32;
            }
        }
        -1
    }
}