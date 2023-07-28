impl Solution {
    pub fn max_sliding_window(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut max = std::i32::MIN;
        let mut max_index = 0;
        let mut result = Vec::new();
        for i in 0..nums.len() {
            if i >= k as usize {
                if max_index == i - k as usize {
                    max = std::i32::MIN;
                    for j in i - k as usize + 1..i {
                        if nums[j] > max {
                            max = nums[j];
                            max_index = j;
                        }
                    }
                }
            }
            if nums[i] > max {
                max = nums[i];
                max_index = i;
            }
            if i >= k as usize - 1 {
                result.push(max);
            }
        }
        result
    }
}