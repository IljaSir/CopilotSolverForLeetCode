impl Solution {
    pub fn lemonade_change(bills: Vec<i32>) -> bool {
        
        let mut change = 0;
        for bill in bills {
            if bill == 5 {
                change += 5;
            } else if bill == 10 {
                if change < 5 {
                    return false;
                } else {
                    change -= 5;
                    change += 10;
                }
            } else if bill == 20 {
                if change < 15 {
                    return false;
                } else {
                    if change >= 10 {
                        change -= 10;
                        change += 20;
                    } else {
                        change -= 5;
                        change -= 5;
                        change -= 5;
                        change += 20;
                    }
                }
            }
        }
        true
    }
}