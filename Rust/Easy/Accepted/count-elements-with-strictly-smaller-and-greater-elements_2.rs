impl Solution {
    pub fn count_elements(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        for i in 0..nums.len() {
            let mut greater = false;
            let mut smaller = false;
            for j in 0..nums.len() {
                if i != j {
                    if nums[i] < nums[j] {
                        greater = true;
                    } else if nums[i] > nums[j] {
                        smaller = true;
                    }
                }
            }
            if greater && smaller {
                count += 1;
            }
        }
        count
    }
}