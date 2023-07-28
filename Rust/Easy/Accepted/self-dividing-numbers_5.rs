impl Solution {
    pub fn self_dividing_numbers(left: i32, right: i32) -> Vec<i32> {
        
        let mut result = Vec::new();
        for i in left..=right {
            let mut j = i;
            let mut is_self_dividing = true;
            while j > 0 {
                let digit = j % 10;
                if digit == 0 || i % digit != 0 {
                    is_self_dividing = false;
                    break;
                }
                j /= 10;
            }
            if is_self_dividing {
                result.push(i);
            }
        }
        result
    }
}