impl Solution {
    pub fn fill_cups(amount: Vec<i32>) -> i32 {
        
        let mut amount = amount;
        let mut ans = 0;
        while amount[0] > 0 || amount[1] > 0 || amount[2] > 0 {
            if amount[0] > 0 && amount[1] > 0 {
                amount[0] -= 1;
                amount[1] -= 1;
                ans += 1;
            } else if amount[1] > 0 && amount[2] > 0 {
                amount[1] -= 1;
                amount[2] -= 1;
                ans += 1;
            } else if amount[0] > 0 && amount[2] > 0 {
                amount[0] -= 1;
                amount[2] -= 1;
                ans += 1;
            } else {
                let m = amount.iter().max().unwrap();
                let i = amount.iter().position(|&x| x == *m).unwrap();
                amount[i] -= 1;
                ans += 1;
            }
        }
        ans
    }
}