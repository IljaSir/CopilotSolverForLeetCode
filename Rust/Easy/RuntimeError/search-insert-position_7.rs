impl Solution {
    pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
        
        let mut i = 0;
        let mut j = nums.len() - 1;
        while i <= j {
            let m = (i + j) / 2;
            if nums[m] == target {
                return m as i32;
            }
            if nums[m] < target {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        i as i32
    }
}