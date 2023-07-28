impl Solution {
    pub fn find_score(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut score = 0;
        let mut i = 0;
        while i < nums.len() {
            let mut min = (i32::MAX, i32::MAX);
            for j in 0..nums.len() {
                if nums[j] < min.0 && nums[j] != -1 {
                    min = (nums[j], j as i32);
                }
            }
            if min.0 == i32::MAX {
                break;
            }
            score += min.0 as i64;
            let left = min.1 - 1;
            let right = min.1 + 1;
            if left >= 0 {
                nums[left as usize] = -1;
            }
            nums[min.1 as usize] = -1;
            if right < nums.len() as i32 {
                nums[right as usize] = -1;
            }
            i += 3;
        }
        score
    }
}