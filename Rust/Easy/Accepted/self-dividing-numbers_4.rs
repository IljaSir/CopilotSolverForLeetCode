impl Solution {
    pub fn self_dividing_numbers(left: i32, right: i32) -> Vec<i32> {
        
        let mut res = Vec::new();
        for i in left..=right {
            if i % 10 == 0 {
                continue;
            }
            let mut j = i;
            let mut flag = true;
            while j > 0 {
                let d = j % 10;
                if d == 0 || i % d != 0 {
                    flag = false;
                    break;
                }
                j /= 10;
            }
            if flag {
                res.push(i);
            }
        }
        res
    }
}