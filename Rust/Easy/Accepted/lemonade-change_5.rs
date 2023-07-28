impl Solution {
    pub fn lemonade_change(bills: Vec<i32>) -> bool {
        
        let mut fives = 0;
        let mut tens = 0;
        for bill in bills {
            match bill {
                5 => fives += 1,
                10 => {
                    tens += 1;
                    fives -= 1;
                }
                20 => {
                    if tens > 0 {
                        tens -= 1;
                        fives -= 1;
                    } else {
                        fives -= 3;
                    }
                }
                _ => {}
            }
            if fives < 0 {
                return false;
            }
        }
        true
    }
}