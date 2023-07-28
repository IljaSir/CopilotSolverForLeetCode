impl Solution {
    pub fn self_dividing_numbers(left: i32, right: i32) -> Vec<i32> {
        
        let mut res = Vec::new();
        for i in left..=right {
            let mut num = i;
            let mut ok = true;
            while num > 0 {
                let digit = num % 10;
                if digit == 0 || i % digit != 0 {
                    ok = false;
                    break;
                }
                num /= 10;
            }
            if ok {
                res.push(i);
            }
        }
        res
    }
}