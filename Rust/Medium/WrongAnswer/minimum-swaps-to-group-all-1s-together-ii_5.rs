impl Solution {
    pub fn min_swaps(nums: Vec<i32>) -> i32 {
        
        let mut ones = nums.iter().filter(|&&x| x == 1).count();
        let mut i = 0;
        for j in 0..nums.len() {
            if nums[j] == 1 {
                ones -= 1;
            }
            if ones == 0 {
                break;
            }
            i += 1;
        }
        let mut zero = 0;
        for j in 0..nums.len() {
            if nums[j] == 0 {
                zero += 1;
            }
            if j >= i {
                if nums[j - i] == 0 {
                    zero -= 1;
                }
            }
            if j >= i - 1 {
                ones = std::cmp::max(ones, zero);
            }
        }
        (i - ones) as i32
    }
}