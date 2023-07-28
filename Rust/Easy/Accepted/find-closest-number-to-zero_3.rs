impl Solution {
    pub fn find_closest_number(nums: Vec<i32>) -> i32 {
        
        let mut closest = std::i32::MAX;
        let mut closest_num = 0;
        for num in nums {
            if num.abs() < closest {
                closest = num.abs();
                closest_num = num;
            } else if num.abs() == closest && num > closest_num {
                closest_num = num;
            }
        }
        closest_num
    }
}