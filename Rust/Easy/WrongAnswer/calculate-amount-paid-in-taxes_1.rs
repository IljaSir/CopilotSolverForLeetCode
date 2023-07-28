impl Solution {
    pub fn calculate_tax(brackets: Vec<Vec<i32>>, income: i32) -> f64 {
        
        let mut tax = 0.0;
        let mut income = income as f64;
        for bracket in brackets {
            let upper = bracket[0] as f64;
            let percent = bracket[1] as f64;
            if income > upper {
                tax += upper * percent / 100.0;
                income -= upper;
            } else {
                tax += income * percent / 100.0;
                break;
            }
        }
        tax
    }
}