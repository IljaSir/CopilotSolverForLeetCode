impl Solution {
    pub fn third_max(nums: Vec<i32>) -> i32 {
        
        let mut max1 = std::i32::MIN;
        let mut max2 = std::i32::MIN;
        let mut max3 = std::i32::MIN;
        let mut count = 0;
        for num in nums.iter() {
            if *num > max1 {
                max3 = max2;
                max2 = max1;
                max1 = *num;
                count += 1;
            } else if *num > max2 && *num < max1 {
                max3 = max2;
                max2 = *num;
                count += 1;
            } else if *num > max3 && *num < max2 {
                max3 = *num;
                count += 1;
            }
        }
        if count >= 3 {
            return max3;
        } else {
            return max1;
        }
    }
}