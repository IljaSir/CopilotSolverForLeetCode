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
            let mut count = 1;
            while j < nums.len() {
                if nums[j] == nums[i] {
                    j += 1;
                } else if nums[j] == nums[i] + 1 {
                    count += 1;
                    nums[j] = nums[i];
                    j += 1;
                } else {
                    break;
                }
                if count == k {
                    break;
                }
            }
            if count != k {
                return false;
            }
            i = j;
        }
        true
    }
}