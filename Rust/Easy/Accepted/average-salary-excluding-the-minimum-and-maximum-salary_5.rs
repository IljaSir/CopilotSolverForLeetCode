impl Solution {
    pub fn average(salary: Vec<i32>) -> f64 {
        
        let mut sum: i32 = 0;
        let mut min: i32 = salary[0];
        let mut max: i32 = salary[0];
        for i in 0..salary.len() {
            sum += salary[i];
            if salary[i] < min {
                min = salary[i];
            }
            if salary[i] > max {
                max = salary[i];
            }
        }
        (sum - min - max) as f64 / (salary.len() - 2) as f64
    }
}