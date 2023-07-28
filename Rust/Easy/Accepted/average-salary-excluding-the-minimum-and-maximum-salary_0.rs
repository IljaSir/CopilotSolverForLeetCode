impl Solution {
    pub fn average(salary: Vec<i32>) -> f64 {
        
        let mut min = salary[0];
        let mut max = salary[0];
        let mut sum = salary[0];
        for i in 1..salary.len() {
            if salary[i] < min {
                min = salary[i];
            }
            if salary[i] > max {
                max = salary[i];
            }
            sum += salary[i];
        }
        (sum - min - max) as f64 / (salary.len() - 2) as f64
    }
}