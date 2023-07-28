impl Solution {
    pub fn schedule_course(courses: Vec<Vec<i32>>) -> i32 {
        
        let mut courses = courses;
        courses.sort_by_key(|c| c[1]);
        let mut time = 0;
        let mut pq = std::collections::BinaryHeap::new();
        for c in courses {
            if time + c[0] <= c[1] {
                time += c[0];
                pq.push(c[0]);
            } else if let Some(&t) = pq.peek() {
                if t > c[0] {
                    time += c[0] - t;
                    pq.pop();
                    pq.push(c[0]);
                }
            }
        }
        pq.len() as i32
    }
}