impl Solution {
    pub fn fill_cups(amount: Vec<i32>) -> i32 {
        
        let mut amount = amount;
        let mut res = 0;
        let mut n = 0;
        while amount[0] > 0 || amount[1] > 0 || amount[2] > 0 {
            res += 1;
            n = 0;
            for i in 0..3 {
                if amount[i] > 0 {
                    amount[i] -= 1;
                    n += 1;
                }
            }
            if n == 0 {
                amount[0] += 2;
            }
            if n == 1 {
                amount[1] += 1;
            }
            if n == 2 {
                amount[2] += 1;
            }
        }
        res
    }
}