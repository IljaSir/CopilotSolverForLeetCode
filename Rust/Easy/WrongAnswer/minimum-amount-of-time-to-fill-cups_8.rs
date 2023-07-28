impl Solution {
    pub fn fill_cups(amount: Vec<i32>) -> i32 {
        
        let mut total = 0;
        let mut extra = 0;
        for i in 0..3 {
            total += amount[i];
            if i > 0 {
                extra += (amount[i-1] - amount[i]).abs();
            }
        }
        (total + extra/2) as i32
    }
}