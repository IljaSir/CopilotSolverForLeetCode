impl Solution {
    pub fn busy_student(start_time: Vec<i32>, end_time: Vec<i32>, query_time: i32) -> i32 {
        
        start_time.iter().zip(end_time.iter()).filter(|(st, et)| **st <= query_time && **et >= query_time).count() as i32
    }
}