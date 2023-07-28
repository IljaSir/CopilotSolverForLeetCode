impl Solution {
    pub fn self_dividing_numbers(left: i32, right: i32) -> Vec<i32> {
        
        let mut result = Vec::new();
        for i in left..=right {
            let mut flag = true;
            for c in i.to_string().chars() {
                if c == '0' || i % (c as i32 - '0' as i32) != 0 {
                    flag = false;
                    break;
                }
            }
            if flag {
                result.push(i);
            }
        }
        result
    }
}