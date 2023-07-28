impl Solution {
    pub fn is_possible_divide(nums: Vec<i32>, k: i32) -> bool {
        
        if k == 1 { return true; }
        if nums.len() % k as usize != 0 { return false; }
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            let mut count = 1;
            let mut last = nums[i];
            while j < nums.len() {
                if nums[j] == last + 1 {
                    count += 1;
                    last = nums[j];
                    if count == k as usize {
                        nums.remove(i);
                        nums.remove(i);
                        nums.remove(i);
                        i = 0;
                        break;
                    }
                }
                j += 1;
            }
            if count != k as usize { return false; }
            i += 1;
        }
        true
    }
}