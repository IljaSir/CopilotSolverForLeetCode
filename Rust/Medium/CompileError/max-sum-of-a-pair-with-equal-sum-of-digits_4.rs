impl Solution {
    pub fn maximum_sum(nums: Vec<i32>) -> i32 {
        
        let mut max = -1;
        let mut max_index = -1;
        let mut second_max = -1;
        let mut second_max_index = -1;
        for (i, &n) in nums.iter().enumerate() {
            let sum = n.to_string().chars().map(|c| c.to_digit(10).unwrap()).sum::<u32>();
            if sum > max {
                second_max = max;
                second_max_index = max_index;
                max = sum;
                max_index = i as i32;
            } else if sum > second_max {
                second_max = sum;
                second_max_index = i as i32;
            }
        }
        if max_index != second_max_index {
            nums[max_index as usize] + nums[second_max_index as usize]
        } else {
            -1
        }
    }
}