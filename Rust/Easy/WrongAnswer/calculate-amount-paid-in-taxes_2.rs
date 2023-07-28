impl Solution {
    pub fn calculate_tax(brackets: Vec<Vec<i32>>, income: i32) -> f64 {
        
        let mut tax = 0.0;
        let mut income = income;
        for i in 0..brackets.len() {
            if income > brackets[i][0] {
                tax += brackets[i][0] as f64 * brackets[i][1] as f64 / 100.0;
                income -= brackets[i][0];
            } else {
                tax += income as f64 * brackets[i][1] as f64 / 100.0;
                break;
            }
        }
        tax
    }
}