impl Solution {
    pub fn count_hill_valley(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut prev = nums[0];
        let mut is_hill = false;
        for i in 1..nums.len() {
            if nums[i] == prev {
                continue;
            }
            if nums[i] > prev {
                if !is_hill {
                    count += 1;
                    is_hill = true;
                }
            } else {
                if is_hill {
                    count += 1;
                    is_hill = false;
                }
            }
            prev = nums[i];
        }
        count
    }
}