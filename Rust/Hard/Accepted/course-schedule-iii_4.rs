impl Solution {
    pub fn schedule_course(courses: Vec<Vec<i32>>) -> i32 {
        
        let mut courses = courses;
        courses.sort_by_key(|x| x[1]);
        let mut pq = std::collections::BinaryHeap::new();
        let mut time = 0;
        for course in courses {
            if time + course[0] <= course[1] {
                time += course[0];
                pq.push(course[0]);
            } else if let Some(&max) = pq.peek() {
                if max > course[0] {
                    time -= max - course[0];
                    pq.pop();
                    pq.push(course[0]);
                }
            }
        }
        pq.len() as i32
    }
}