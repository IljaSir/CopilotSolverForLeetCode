impl Solution {
    pub fn fill_cups(amount: Vec<i32>) -> i32 {
        
        let mut amount = amount;
        let mut res = 0;
        let mut i = 0;
        while amount.iter().any(|x| *x > 0) {
            if amount[i] > 0 {
                amount[i] -= 1;
            }
            i = (i + 1) % 3;
            res += 1;
        }
        res
    }
}