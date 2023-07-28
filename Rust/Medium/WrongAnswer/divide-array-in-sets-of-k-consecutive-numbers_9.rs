impl Solution {
    pub fn is_possible_divide(nums: Vec<i32>, k: i32) -> bool {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            let mut count = 1;
            while j < nums.len() && count < k {
                if nums[j] == nums[j-1] + 1 {
                    count += 1;
                } else if nums[j] == nums[j-1] {
                    // do nothing
                } else {
                    break;
                }
                j += 1;
            }
            if count == k {
                nums.drain(i..j);
            } else {
                return false;
            }
        }
        nums.is_empty()
    }
}