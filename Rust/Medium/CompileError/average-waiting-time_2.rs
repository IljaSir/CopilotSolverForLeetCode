impl Solution {
    pub fn average_waiting_time(customers: Vec<Vec<i32>>) -> f64 {
        
        let mut start = 0;
        let mut total = 0;
        for customer in customers {
            let arrival = customer[0];
            let duration = customer[1];
            if arrival > start {
                start = arrival + duration;
            } else {
                start += duration;
            }
            total += start - arrival;
        }
        total as f64 / customers.len() as f64
    }
}