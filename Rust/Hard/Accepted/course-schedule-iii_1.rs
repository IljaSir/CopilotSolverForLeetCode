impl Solution {
    pub fn schedule_course(courses: Vec<Vec<i32>>) -> i32 {
        
        let mut courses = courses;
        courses.sort_by_key(|c| c[1]);
        let mut pq: std::collections::BinaryHeap<i32> = std::collections::BinaryHeap::new();
        let mut time = 0;
        for c in courses {
            pq.push(c[0]);
            time += c[0];
            if time > c[1] {
                time -= pq.pop().unwrap();
            }
        }
        pq.len() as i32
    }
}