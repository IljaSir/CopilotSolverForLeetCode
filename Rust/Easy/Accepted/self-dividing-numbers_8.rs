impl Solution {
    pub fn self_dividing_numbers(left: i32, right: i32) -> Vec<i32> {
        
        let mut res: Vec<i32> = vec![];
        for i in left..=right {
            let mut tmp = i;
            let mut flag = true;
            while tmp != 0 {
                let last = tmp % 10;
                if last == 0 || i % last != 0 {
                    flag = false;
                    break;
                }
                tmp /= 10;
            }
            if flag {
                res.push(i);
            }
        }
        res
    }
}