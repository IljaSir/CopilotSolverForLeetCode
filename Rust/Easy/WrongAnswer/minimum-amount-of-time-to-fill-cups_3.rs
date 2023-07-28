impl Solution {
    pub fn fill_cups(amount: Vec<i32>) -> i32 {
        
        let mut amount = amount;
        let mut ans = 0;
        while amount[0] > 0 || amount[1] > 0 || amount[2] > 0 {
            if amount[0] > 0 && amount[1] > 0 {
                amount[0] -= 1;
                amount[1] -= 1;
                ans += 2;
            } else if amount[1] > 0 && amount[2] > 0 {
                amount[1] -= 1;
                amount[2] -= 1;
                ans += 2;
            } else if amount[0] > 0 && amount[2] > 0 {
                amount[0] -= 1;
                amount[2] -= 1;
                ans += 2;
            } else {
                let max = amount.iter().max().unwrap();
                let idx = amount.iter().position(|&x| x == *max).unwrap();
                amount[idx] -= 1;
                ans += 1;
            }
        }
        ans
    }
}