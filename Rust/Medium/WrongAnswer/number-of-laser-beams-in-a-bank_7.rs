impl Solution {
    pub fn number_of_beams(bank: Vec<String>) -> i32 {
        
        let mut result = 0;
        let mut previous = String::new();
        for row in bank {
            if row.contains('1') {
                if !previous.is_empty() {
                    result += row.chars().filter(|&c| c == '1').count() as i32;
                }
                previous = row;
            }
        }
        result
    }
}