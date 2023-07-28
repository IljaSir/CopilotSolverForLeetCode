impl Solution {
    pub fn lemonade_change(bills: Vec<i32>) -> bool {
        
        let mut five = 0;
        let mut ten = 0;
        for bill in bills {
            match bill {
                5 => five += 1,
                10 => {
                    five -= 1;
                    ten += 1;
                }
                20 => {
                    if ten > 0 {
                        ten -= 1;
                        five -= 1;
                    } else {
                        five -= 3;
                    }
                }
                _ => panic!("Invalid bill!"),
            }
            if five < 0 || ten < 0 {
                return false;
            }
        }
        true
    }
}