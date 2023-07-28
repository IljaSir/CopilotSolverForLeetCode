impl Solution {
    pub fn third_max(nums: Vec<i32>) -> i32 {
        
        let mut max = i32::MIN;
        let mut second = i32::MIN;
        let mut third = i32::MIN;
        for i in nums {
            if i > max {
                third = second;
                second = max;
                max = i;
            } else if i > second && i < max {
                third = second;
                second = i;
            } else if i > third && i < second {
                third = i;
            }
        }
        if third == i32::MIN {
            max
        } else {
            third
        }
    }
}