impl Solution {
    pub fn maximum_sum(nums: Vec<i32>) -> i32 {
        
        let mut max = -1;
        let mut max1 = -1;
        let mut max2 = -1;
        for num in nums {
            let sum = num.to_string().chars().map(|c| c.to_digit(10).unwrap()).sum::<u32>();
            if sum > max1 {
                max2 = max1;
                max1 = sum;
            } else if sum > max2 {
                max2 = sum;
            }
            if max1 != max2 && max1 + max2 > max {
                max = max1 + max2;
            }
        }
        max
    }
}