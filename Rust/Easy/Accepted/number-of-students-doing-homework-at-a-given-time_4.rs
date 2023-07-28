impl Solution {
    pub fn busy_student(start_time: Vec<i32>, end_time: Vec<i32>, query_time: i32) -> i32 {
        
        let mut count = 0;
        for (s, e) in start_time.iter().zip(end_time.iter()) {
            if s <= &query_time && e >= &query_time {
                count += 1;
            }
        }
        count
    }
}