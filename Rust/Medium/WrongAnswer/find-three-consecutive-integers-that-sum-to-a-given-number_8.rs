impl Solution {
    pub fn sum_of_three(num: i64) -> Vec<i64> {
        
        let mut res = Vec::new();
        for i in 0..=num/3 {
            if i*(i+1)/2 == num - i*(i+1)/2 - (i+1) {
                for j in 0..i {
                    res.push(i-j);
                }
                return res;
            }
        }
        res
    }
}