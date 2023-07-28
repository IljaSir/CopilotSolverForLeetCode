impl Solution {
    pub fn self_dividing_numbers(left: i32, right: i32) -> Vec<i32> {
        
        let mut result = Vec::new();
        for i in left..=right {
            let mut tmp = i;
            let mut flag = true;
            while tmp > 0 {
                let digit = tmp % 10;
                if digit == 0 || i % digit != 0 {
                    flag = false;
                    break;
                }
                tmp /= 10;
            }
            if flag {
                result.push(i);
            }
        }
        result
    }
}