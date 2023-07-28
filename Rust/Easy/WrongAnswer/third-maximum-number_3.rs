impl Solution {
    pub fn third_max(nums: Vec<i32>) -> i32 {
        
        let mut max = std::i32::MIN;
        let mut second = std::i32::MIN;
        let mut third = std::i32::MIN;
        for num in nums {
            if num > max {
                third = second;
                second = max;
                max = num;
            } else if num > second && num < max {
                third = second;
                second = num;
            } else if num > third && num < second {
                third = num;
            }
        }
        if third == std::i32::MIN {
            max
        } else {
            third
        }
    }
}