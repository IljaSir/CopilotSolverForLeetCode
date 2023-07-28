impl Solution {
    pub fn number_of_beams(bank: Vec<String>) -> i32 {
        
        let mut sum = 0;
        for i in 0..bank[0].len() {
            let mut first = -1;
            for j in 0..bank.len() {
                if bank[j].chars().nth(i).unwrap() == '1' {
                    if first == -1 {
                        first = j as i32;
                    } else {
                        sum += j as i32 - first - 1;
                    }
                }
            }
        }
        sum
    }
}