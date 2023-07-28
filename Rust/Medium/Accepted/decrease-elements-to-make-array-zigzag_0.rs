impl Solution {
    pub fn moves_to_make_zigzag(nums: Vec<i32>) -> i32 {
        
        let mut odd = 0;
        let mut even = 0;
        for i in 0..nums.len() {
            if i % 2 == 0 {
                let left = if i == 0 { 1001 } else { nums[i - 1] };
                let right = if i == nums.len() - 1 { 1001 } else { nums[i + 1] };
                let min = std::cmp::min(left, right);
                if nums[i] >= min {
                    even += nums[i] - min + 1;
                }
            } else {
                let left = if i == 0 { 1001 } else { nums[i - 1] };
                let right = if i == nums.len() - 1 { 1001 } else { nums[i + 1] };
                let min = std::cmp::min(left, right);
                if nums[i] >= min {
                    odd += nums[i] - min + 1;
                }
            }
        }
        std::cmp::min(odd, even)
    }
}