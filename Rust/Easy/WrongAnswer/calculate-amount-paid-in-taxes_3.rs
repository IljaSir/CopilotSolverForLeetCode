impl Solution {
    pub fn calculate_tax(brackets: Vec<Vec<i32>>, income: i32) -> f64 {
        
        let mut tax = 0.0;
        let mut income = income;
        for bracket in brackets {
            let upper = bracket[0];
            let percent = bracket[1];
            let taxed = income.min(upper);
            tax += taxed as f64 * percent as f64 / 100.0;
            income -= taxed;
        }
        tax
    }
}