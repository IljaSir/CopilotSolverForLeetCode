impl Solution {
    pub fn number_of_beams(bank: Vec<String>) -> i32 {
        
        let mut count = 0;
        let mut last_row = 0;
        let mut last_col = 0;
        for (i, row) in bank.iter().enumerate() {
            if row.contains('1') {
                for (j, c) in row.chars().enumerate() {
                    if c == '1' {
                        if i != last_row {
                            count += 1;
                            last_row = i;
                            last_col = j;
                        } else if j != last_col {
                            count += 1;
                            last_row = i;
                            last_col = j;
                        }
                    }
                }
            }
        }
        count
    }
}