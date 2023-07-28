impl Solution {
    pub fn schedule_course(courses: Vec<Vec<i32>>) -> i32 {
        
        let mut courses = courses;
        courses.sort_by_key(|c| c[1]);
        let mut heap = std::collections::BinaryHeap::new();
        let mut time = 0;
        for course in courses {
            if time + course[0] <= course[1] {
                time += course[0];
                heap.push(course[0]);
            } else if let Some(&top) = heap.peek() {
                if top > course[0] {
                    time += course[0] - top;
                    heap.pop();
                    heap.push(course[0]);
                }
            }
        }
        heap.len() as i32
    }
}