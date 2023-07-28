impl Solution {
    pub fn self_dividing_numbers(left: i32, right: i32) -> Vec<i32> {
        
        let mut result = Vec::new();
        for i in left..=right {
            let mut flag = true;
            let mut j = i;
            while j > 0 {
                let k = j % 10;
                if k == 0 || i % k != 0 {
                    flag = false;
                    break;
                }
                j /= 10;
            }
            if flag {
                result.push(i);
            }
        }
        result
    }
}