impl Solution {
    pub fn fill_cups(amount: Vec<i32>) -> i32 {
        
        let mut result = 0;
        let mut cold = amount[0];
        let mut warm = amount[1];
        let mut hot = amount[2];
        while cold > 0 || warm > 0 || hot > 0 {
            if cold > 0 && warm > 0 {
                cold -= 1;
                warm -= 1;
            } else if cold > 0 && hot > 0 {
                cold -= 1;
                hot -= 1;
            } else if warm > 0 && hot > 0 {
                warm -= 1;
                hot -= 1;
            } else if cold > 0 {
                cold -= 1;
            } else if warm > 0 {
                warm -= 1;
            } else if hot > 0 {
                hot -= 1;
            }
            result += 1;
        }
        result
    }
}