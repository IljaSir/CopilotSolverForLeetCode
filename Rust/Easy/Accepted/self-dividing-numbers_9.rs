impl Solution {
    pub fn self_dividing_numbers(left: i32, right: i32) -> Vec<i32> {
        
        let mut ans = vec![];
        for i in left..=right {
            let mut is_self_dividing = true;
            let mut t = i;
            while t > 0 {
                let digit = t % 10;
                if digit == 0 || i % digit != 0 {
                    is_self_dividing = false;
                    break;
                }
                t /= 10;
            }
            if is_self_dividing {
                ans.push(i);
            }
        }
        ans
    }
}