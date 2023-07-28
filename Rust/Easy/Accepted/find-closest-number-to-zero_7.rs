impl Solution {
    pub fn find_closest_number(nums: Vec<i32>) -> i32 {
        
        let mut closest_number = 0;
        let mut closest_number_distance = i32::max_value();
        for number in nums {
            let distance = number.abs();
            if distance < closest_number_distance {
                closest_number_distance = distance;
                closest_number = number;
            } else if distance == closest_number_distance {
                closest_number = std::cmp::max(closest_number, number);
            }
        }
        closest_number
    }
}