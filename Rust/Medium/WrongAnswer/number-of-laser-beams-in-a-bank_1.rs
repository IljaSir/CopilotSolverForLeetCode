impl Solution {
    pub fn number_of_beams(bank: Vec<String>) -> i32 {
        
        let mut res = 0;
        let mut prev = 0;
        for i in 0..bank.len() {
            let mut cur = 0;
            for j in 0..bank[i].len() {
                if bank[i].chars().nth(j).unwrap() == '1' {
                    cur += 1;
                }
            }
            res += cur * prev;
            prev = cur;
        }
        res
    }
}