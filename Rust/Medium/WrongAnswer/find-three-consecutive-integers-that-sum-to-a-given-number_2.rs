impl Solution {
    pub fn sum_of_three(num: i64) -> Vec<i64> {
        
        let mut res: Vec<i64> = Vec::new();
        for i in 0..num {
            let x = i + 1;
            let y = x + 1;
            let z = y + 1;
            if x + y + z == num {
                res.push(x);
                res.push(y);
                res.push(z);
                break;
            }
        }
        res
    }
}