impl Solution {
    pub fn schedule_course(courses: Vec<Vec<i32>>) -> i32 {
        
        let mut courses = courses;
        courses.sort_by_key(|&c| c[1]);
        let mut heap = std::collections::BinaryHeap::new();
        let mut t = 0;
        for c in courses {
            if t + c[0] <= c[1] {
                t += c[0];
                heap.push(c[0]);
            } else if let Some(&top) = heap.peek() {
                if top > c[0] {
                    t += c[0] - top;
                    heap.pop();
                    heap.push(c[0]);
                }
            }
        }
        heap.len() as i32
    }
}