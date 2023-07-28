impl Solution {
    pub fn is_possible_divide(nums: Vec<i32>, k: i32) -> bool {
        
        if nums.len() % k as usize != 0 {
            return false;
        }
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            let mut min = nums[i];
            while j < nums.len() {
                if nums[j] != min + 1 {
                    return false;
                }
                min = nums[j];
                j += 1;
                if (j - i) % k as usize == 0 {
                    break;
                }
            }
            nums.drain(i..j);
        }
        true
    }
}