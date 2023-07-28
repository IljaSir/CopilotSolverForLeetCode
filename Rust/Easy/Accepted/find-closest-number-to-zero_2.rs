impl Solution {
    pub fn find_closest_number(nums: Vec<i32>) -> i32 {
        
        let mut min = std::i32::MAX;
        let mut ans = 0;
        for num in nums {
            if num.abs() < min {
                min = num.abs();
                ans = num;
            } else if num.abs() == min && num > ans {
                ans = num;
            }
        }
        ans
    }
}