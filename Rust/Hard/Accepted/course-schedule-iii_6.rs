impl Solution {
    pub fn schedule_course(courses: Vec<Vec<i32>>) -> i32 {
        
        let mut courses = courses;
        courses.sort_by_key(|v| v[1]);
        let mut pq = std::collections::BinaryHeap::new();
        let mut time = 0;
        for v in courses {
            if time + v[0] <= v[1] {
                time += v[0];
                pq.push(v[0]);
            } else if let Some(&x) = pq.peek() {
                if x > v[0] {
                    time += v[0] - x;
                    pq.pop();
                    pq.push(v[0]);
                }
            }
        }
        pq.len() as i32
    }
}