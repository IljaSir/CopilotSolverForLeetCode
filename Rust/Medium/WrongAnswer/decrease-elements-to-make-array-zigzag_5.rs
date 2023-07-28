impl Solution {
    pub fn moves_to_make_zigzag(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut nums = nums;
        for i in 0..nums.len() {
            if i % 2 == 0 {
                if i == 0 {
                    if nums.len() > 1 && nums[i] >= nums[i + 1] {
                        ans += nums[i] - nums[i + 1] + 1;
                    }
                } else if i == nums.len() - 1 {
                    if nums[i] >= nums[i - 1] {
                        ans += nums[i] - nums[i - 1] + 1;
                    }
                } else {
                    let max = std::cmp::max(nums[i - 1], nums[i + 1]);
                    if nums[i] >= max {
                        ans += nums[i] - max + 1;
                    }
                }
            } else {
                if i == 0 {
                    if nums.len() > 1 && nums[i] >= nums[i + 1] {
                        ans += nums[i] - nums[i + 1] + 1;
                    }
                } else if i == nums.len() - 1 {
                    if nums[i] >= nums[i - 1] {
                        ans += nums[i] - nums[i - 1] + 1;
                    }
                } else {
                    let min = std::cmp::min(nums[i - 1], nums[i + 1]);
                    if nums[i] >= min {
                        ans += nums[i] - min + 1;
                    }
                }
            }
        }
        ans
    }
}