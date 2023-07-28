impl Solution {
    pub fn is_possible_divide(nums: Vec<i32>, k: i32) -> bool {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i < nums.len() {
            if nums[i] == 0 {
                i += 1;
                continue;
            }
            let mut j = i + 1;
            let mut n = 1;
            while j < nums.len() && n < k as usize {
                if nums[j] == 0 {
                    j += 1;
                    continue;
                }
                if nums[j] == nums[j - 1] + 1 {
                    nums[j] = 0;
                    n += 1;
                }
                j += 1;
            }
            if n == k as usize {
                nums[i] = 0;
            } else {
                return false;
            }
        }
        true
    }
}