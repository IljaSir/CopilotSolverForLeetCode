impl Solution {
    pub fn sum_of_three(num: i64) -> Vec<i64> {
        
        if num < 3 {
            return Vec::new();
        }
        let mut res = Vec::new();
        for i in 1..(num / 3) {
            if (num - i * 3) % 2 == 0 {
                res.push(i);
                res.push(i + 1);
                res.push(i + 2);
                break;
            }
        }
        res
    }
}