impl Solution {
    pub fn lemonade_change(bills: Vec<i32>) -> bool {
        
        let mut five = 0;
        let mut ten = 0;
        for i in bills {
            match i {
                5 => five += 1,
                10 => {
                    if five == 0 {
                        return false;
                    }
                    five -= 1;
                    ten += 1;
                },
                20 => {
                    if five > 0 && ten > 0 {
                        five -= 1;
                        ten -= 1;
                    } else if five > 2 {
                        five -= 3;
                    } else {
                        return false;
                    }
                },
                _ => unreachable!(),
            }
        }
        true
    }
}