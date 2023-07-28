impl Solution {
    pub fn third_max(nums: Vec<i32>) -> i32 {
        
        let mut max = std::i32::MIN;
        let mut max2 = std::i32::MIN;
        let mut max3 = std::i32::MIN;
        let mut flag = false;
        for i in nums {
            if i > max {
                max3 = max2;
                max2 = max;
                max = i;
            } else if i > max2 && i < max {
                max3 = max2;
                max2 = i;
            } else if i > max3 && i < max2 {
                max3 = i;
            } else if i == max || i == max2 || i == max3 {
                continue;
            }
            flag = true;
        }
        if flag {
            return max3;
        }
        max
    }
}