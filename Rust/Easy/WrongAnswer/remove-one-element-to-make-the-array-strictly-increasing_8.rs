impl Solution {
    pub fn can_be_increasing(nums: Vec<i32>) -> bool {
        
        let mut i = 0;
        while i < nums.len() - 1 {
            if nums[i] < nums[i + 1] {
                i += 1;
                continue;
            }
            let mut j = i + 2;
            while j < nums.len() {
                if nums[j] <= nums[i] {
                    break;
                }
                j += 1;
            }
            if j == nums.len() {
                return true;
            }
            let mut k = i + 1;
            while k < nums.len() - 1 {
                if nums[k] < nums[k + 1] {
                    k += 1;
                    continue;
                }
                break;
            }
            if k == nums.len() - 1 {
                return true;
            }
            return false;
        }
        true
    }
}