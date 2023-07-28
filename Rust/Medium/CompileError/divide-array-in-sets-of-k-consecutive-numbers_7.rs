impl Solution {
    pub fn is_possible_divide(nums: Vec<i32>, k: i32) -> bool {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            let mut count = 1;
            while j < nums.len() && nums[j] == nums[i] {
                j += 1;
                count += 1;
            }
            if count % k != 0 {
                return false;
            }
            let mut k = k;
            while k > 0 {
                let mut j = i + 1;
                while j < nums.len() {
                    if nums[j] == nums[i] + k {
                        nums.remove(j);
                        break;
                    }
                    j += 1;
                }
                k -= 1;
            }
            i += count;
        }
        true
    }
}